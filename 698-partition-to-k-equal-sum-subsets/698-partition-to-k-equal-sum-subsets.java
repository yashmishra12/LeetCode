class Solution {
  
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;
        
        for (int i = 0; i < n; ++i) {
             totalArraySum += arr[i];
        }
      
        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) { 
            return false;
        }
      
        // Sort in decreasing order.
        Arrays.sort(arr);
        reverse(arr);
        
        int targetSum = totalArraySum / k;
        
        char[] taken = new char[n];
        
        for(int i = 0; i < n; ++i) { taken[i] = '0'; }
        
        HashMap<String, Boolean> memo = new HashMap<>();
        return backtrack(arr, 0, 0, k, targetSum, taken, memo);
    }
        
    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) { 
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    private boolean backtrack(int[] arr, int count, int currSum, int k, 
                              int targetSum, char[] taken, HashMap<String, Boolean> memo) 
    {

        int n = arr.length;
      
        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {  return true; }
        
        // No need to proceed further.
        if (currSum > targetSum) {  return false; }
        
        String takenStr = new String(taken);
        
        // If we have already computed the current combination.
        if (memo.containsKey(takenStr)) { return memo.get(takenStr); }
      
        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            boolean ans = backtrack(arr, count + 1, 0, k, targetSum, taken, memo);
            memo.put(takenStr, ans);
            return ans;
        }
        
        // Try not picked elements to make some combinations.
        for (int j = 0; j < n; ++j) {
            if (taken[j] == '0') {
                // Include this element in current subset.
                taken[j] = '1';
                
                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, count, currSum + arr[j], k, targetSum, taken, memo)) {
                    return true;
                }
                
                // Backtrack step.
                taken[j] = '0';
            }
        } 
      
        // We were not able to make a valid combination after picking each element from array,
        // hence we can't make k subsets.
        memo.put(takenStr, false);
        return false;
    }
}