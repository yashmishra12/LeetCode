class Solution {
    public int[] countBits(int n) {
        
        int[] res = new int[n+1];
        
        int start = 0;
        
        while(start<=n) {
            
            int curNum = start;
            int count=0;
            
            while(curNum!=0) {
                curNum = curNum & (curNum-1);
                count++;
            }
            
            res[start]=count;
            
            start++;
        }
        return (res);
    }
    
}