class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans=0;
        int n=arr.length; // length of array
        for(int i=0;i<n;i++){  // move i index 0 to n
            int leftBracketComb = i+1;
            int rightBracketComb = n-i;
            int numOfSubarray = leftBracketComb*rightBracketComb;
            int oddSubarray = numOfSubarray%2==0?numOfSubarray/2:numOfSubarray/2 + 1;
            ans+=arr[i]*oddSubarray; 
        }
        return ans;
    }
}