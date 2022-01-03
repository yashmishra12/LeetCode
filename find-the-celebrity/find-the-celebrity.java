/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        int[][] dp = new int[n][n];
        
        for(int i=0; i<dp.length;i++) {
            for(int j=0; j<dp.length; j++) {
                dp[i][j] = knows(i, j)==true ? 1:0 ;
            }
        }
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<dp.length; i++) {
            st.push(i);
        }
        
        while(st.size() >=2) {
            int a = st.pop();
            int b = st.pop();
            if(dp[a][b]==1) 
                st.push(b); 
            else 
                st.push(a);
        }
        
        int pot = st.pop();
        
        for(int i=0; i<dp.length; i++) {
            
            if(i!=pot) 
                {
                    if(dp[i][pot]==0 || dp[pot][i]==1) return -1;
                }
        }
        return pot;
        
    }
}