import java.util.*;

class Solution {
    final int MOD = (int)Math.pow(10,9)+7;
    
    
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] memo = new Integer[n+1][target+1];
        // return helper(memo, 0, n, target, k);
         return solver(memo, n, k, target);
        
    }
    
    int solver(Integer[][] memo, int dice, int face, int target) {
        
        if (target<0) {return 0;}
        if (dice ==0 && target != 0) {return 0;}
        if (dice==0 && target==0) {return 1;}
        
        if(memo[dice][target] != null) {
           return memo[dice][target]; 
        }
        
        int ans = 0;
        for(int i=1; i<=face; i++) {
            ans = (ans + solver(memo, dice-1, face, target-i))%MOD;
        }
        memo[dice][target] = ans;
        return ans;
        
    }
    
//     int helper(Integer[][] memo, int diceIndex, int n, int target, int k) {
//         if (diceIndex==n) {
//             return target==0 ? 1:0;
//         }
        

//         if(diceIndex !=0 && target==0) {return 0;}
//         if(target<0) {return 0;}
        
//         if(memo[diceIndex][target] != null) {
//            return memo[diceIndex][target]; 
//         }
        
//         int ways = 0;
        
//         for(int i=1; i<=k; i++) {
//             ways = (ways+helper(memo, diceIndex+1, n, target-i, k))%MOD;
//         }
//         memo[diceIndex][target] = ways;
        
//         return ways;
        
//     }
}