// class Solution {
//     public boolean canPartitionKSubsets(int[] arr, int k) {
//         int totalSum = 0;
//         int n = arr.length;
        
//         if(k==1) {return true;}
//         if(k>n) {return false;}
        
        
//         for(int i=0; i<n; i++) {
//             totalSum += arr[i];
//         }
        
//         if(totalSum % k != 0) {
//             return false;
//         }
        
//         int targetSum = totalSum / k;
//         boolean[] visited = new boolean[n];
        
//         Arrays.sort(arr);
//         reverse(arr);
        
//         return backtrack(arr, 0,0, k, targetSum, visited);

//     }
    
//     public boolean backtrack(int[] arr, int count, int curSum, int k, int targetSum, boolean[] visited) {
//         int n = arr.length;
        
//         if(count == k-1) {return true;}
        
//         if(curSum > targetSum) {return false;}
        
//         if(curSum == targetSum) { //curSum becomes zero
//             return backtrack(arr, count+1, 0, k, targetSum, visited);
//         }
        
//         for(int i=0; i<n; i++) {
//             if(visited[i] == false) {
//                 visited[i]=true;
//                 if (backtrack(arr, count, curSum+arr[i], k, targetSum, visited)) {
//                     return true;
//                 }
//                 visited[i] = false;
//             }
//         }
        
//         return false;
//     }
    
//      void reverse(int[] arr) {
//         for (int i = 0, j = arr.length - 1; i < j; i++, j--) { 
//             int temp = arr[i];
//             arr[i] = arr[j];
//             arr[j] = temp;
//         }
//     }
  
    
// }

class Solution {
    private boolean backtrack(int[] arr, int index, int count, int currSum, int k, 
                              int targetSum, boolean[] taken) {

        int n = arr.length;
      
        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) { 
            return true;
        }
        
        // No need to proceed further.
        if (currSum > targetSum) { 
            return false;
        }
      
        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            return backtrack(arr, 0, count + 1, 0, k, targetSum, taken);
        }
        
        // Try not picked elements to make some combinations.
        for (int j = index; j < n; ++j) {
            if (!taken[j]) {
                // Include this element in current subset.
                taken[j] = true;
                
                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, j + 1, count, currSum + arr[j], k, targetSum, taken)) {
                    return true;
                }
                
                // Backtrack step.
                taken[j] = false;
            }
        } 
      
        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        return false;
    }
    
    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) { 
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
  
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
        boolean[] taken = new boolean[n];
      
        return backtrack(arr, 0, 0, 0, k, targetSum, taken);
    }
}