class Solution {
    public int findLonelyPixel(char[][] arr) {
        int counter = 0;
        int[] row = new int[arr.length];
        int[] col = new int[arr[0].length];
        HashSet<pair> hs = new HashSet<>();
        
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                
                char curChar = arr[i][j];
                if(curChar != 'B') {continue;}
                row[i]++;
                col[j]++;
                hs.add(new pair(i,j));
               
            }
        }
        
        for(pair p: hs) {
            int i = p.a;
            int j = p.b;
            if(row[i]==1 && col[j]==1) {
                counter++;
            }
        }
        
       
        return counter;
    }
    
    class pair {
        int a;
        int b;
        
        public pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    

}
  