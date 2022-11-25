class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int len = arr.length;
        
        int[] leftMin = new int[len];
        Arrays.fill(leftMin, -1);
        
        int[] rightMin = new int[len];
        Arrays.fill(rightMin, len);
        
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<len; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                int index = s.pop();
                rightMin[index] = i;
            }
            s.push(i);
        }
        s.clear();
        
        for(int i=len-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                int index = s.pop();
                leftMin[index] = i;
            }
            s.push(i);
        }
        s.clear();
        
        long res = 0;
        
        for(int i=0; i<len; i++){
            int leftLen = i-leftMin[i];
            int rightLen = rightMin[i]-i;
            long temp = ((long)arr[i]*leftLen*rightLen)%mod;
            res = (res + temp) %mod;
        }
        return (int)res;
    }
}