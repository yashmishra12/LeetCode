class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int value = Integer.MAX_VALUE;
        int maxFreq = 0;

        for(int n: nums) {
            if(n%2==0) {
                int curr = map.getOrDefault(n,0)+1;
                map.put(n, curr);

                if(curr>maxFreq || (curr==maxFreq && n<value)) {
                    value = n;
                    maxFreq = curr;
                }
            }
        }

        return maxFreq==0 ? -1: value;
    }
}