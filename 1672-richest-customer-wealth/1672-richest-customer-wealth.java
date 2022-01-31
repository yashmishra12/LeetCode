class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int res = Integer.MIN_VALUE;
        int cur = 0;
        
        for(int i=0; i<accounts.length; i++) {
            cur = 0;
            for(int j=0; j<accounts[i].length; j++) {
                cur = cur+accounts[i][j];
            }
            
            if(cur>res) 
                res=cur;
        }
        
        return res;
        
    }
}