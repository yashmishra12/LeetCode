class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int bpointer=-1, spointer=-1, j = -1, ans=0;
        
        HashMap<Integer, Integer> bmap = new HashMap<>();
        HashMap<Integer, Integer> smap = new HashMap<>();
       
        if (k==1) return solveForK1 (nums);
        
        while (true){
            boolean f1 = false, f2 = false, f3 = false;
            
            while (bpointer<nums.length-1){
                f1=true;
                bpointer++;
                int curNum = nums[bpointer];
                bmap.put(curNum, bmap.getOrDefault(curNum, 0)+1);
                
                if(bmap.size()==k+1) {
                    removeFromMap(bmap, curNum);
                    bpointer--;
                    break;
                }
            }
            
            while(spointer<bpointer){
                f2=true;
                spointer++;
                int curNum = nums[spointer];
                smap.put(curNum, smap.getOrDefault(curNum, 0)+1);
                
                if(smap.size()==k){
                    removeFromMap(smap, curNum);
                    spointer--;
                    break;
                }
            }
            
            while(j<spointer){
                if(bmap.size()==k && smap.size()==k-1){
                    ans+=(bpointer-spointer);
                }
                j++;
                int curNum = nums[j];
                removeFromMap(smap, curNum);
                removeFromMap(bmap, curNum);
                
                if(smap.size()<k-1 || bmap.size()<k) break;
            }
            
            if(f1==false && f2==false && f3==false) break;
        }
        
        return ans;
    }
    
    public static void removeFromMap(HashMap<Integer, Integer> map, int num){
        if(map.get(num)==1) map.remove(num);
        else map.put(num, map.get(num)-1);
    }
    
    public static int solveForK1 (int[] arr) {
        int i= -1, j = -1, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (true) {
            boolean f1 = false, f2 = false;
           while(i<arr.length-1){
            f1 = true;
            i++;
            int curNum = arr[i];
            map.put(curNum, map.getOrDefault(curNum, 0)+1);
            
            if(map.size()==2) {
                removeFromMap(map, curNum);
                i--;
                break;
                }
            }
            
            while(j<i){
                f2 = true;
                if(map.size()==1) ans += (i-j);
                j++;
                removeFromMap(map, arr[j]);
                if (map.size()==0) break;
            }
            
            if(f1==false && f2==false) break;
        }
        
        return ans;
    }
}