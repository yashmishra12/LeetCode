// class Solution {
//     class Points{
//         int x;
//         int y;
//         Points(int x, int y){
//             this.x = x;
//             this.y = y;
//         }
//         public String toString(){
//             return x+":"+y;
//         }
//     }
//     public int removeStones(int[][] stones) {
//         Points[] arr = new Points[stones.length];
//         HashMap<Integer, ArrayList<String>> hmx = new HashMap<>();
//         HashMap<Integer, ArrayList<String>> hmy = new HashMap<>();
        
//         for(int i=0; i<arr.length; i++){
//             int x = stones[i][0];
//             int y = stones[i][1];
//             String coord = x+":"+y;
            
//             if(hmx.containsKey(x)){
//                 hmx.get(x).add(coord);
//             }else {
//                 ArrayList<String> tmp = new ArrayList<>();
//                 tmp.add(coord);
//                 hmx.put(x, tmp);
//             }
            
//             if(hmy.containsKey(y)){
//                 hmy.get(y).add(coord);
//             }else {
//                 ArrayList<String> tmp = new ArrayList<>();
//                 tmp.add(coord);
//                 hmy.put(y, tmp);
//             }
            
//             Points p = new Points(x, y);
            
//             arr[i] = p;
//         }
        
//         Arrays.sort(arr, (a,b)->(a.x!=b.x ? b.x-a.x : b.y-a.y));
        
//         int answer = 0;
        
//         for(Points p: arr){
//             int x = p.x;
//             int y = p.y;
//             String coord = x+":"+y;
            
//             if(hmx.get(x).size()>1 || hmy.get(y).size()>1){
//                 answer++;
//                 hmx.get(x).remove(coord);
//                 hmy.get(y).remove(coord);
//             }
            
//         }
        
//         return answer;
//     }
// }

class Solution {
    // Return true if stone a and b shares row or column
    boolean shareSameRowOrColumn(int[] a, int[] b) {
        return a[0] == b[0] || a[1] == b[1];
    }
    
    // Returns the representative of vertex x
    int find(int[] rep, int x) {
        if (x == rep[x]) {
            return x;
        }
        // Uses Path compression
        return rep[x] = find(rep, rep[x]);
    }
    
    // Combine the stone x and y, and returns 1 if they were not connected
    int performUnion(int [] rep, int [] size, int x, int y) {
        x = find(rep, x);
        y = find(rep, y);
        
        if (x == y) {
            return 0;
        }
        
        if (size[x] > size[y]) {
            rep[y] = x;
            size[x] += size[y];
        } else {
            rep[x] = y;
            size[y] += size[x];
        }
        
        return 1;
    }
    
    public int removeStones(int[][] stones) {
        int[] rep = new int[stones.length];
        int[] size = new int[stones.length];
        // Initialize rep to itself and size as 1
        for (int i = 0; i < stones.length; i++) {
            rep[i] = i;
            size[i] = 1;
        }
        
        int componentCount = stones.length;
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (shareSameRowOrColumn(stones[i], stones[j])) {
                    // Decrement the componenets if union invloved merging
                    componentCount -= performUnion(rep, size, i, j);
                }
            }
        }
        
        // Return the maximum stone that can be removed
        return stones.length - componentCount;
    }
};