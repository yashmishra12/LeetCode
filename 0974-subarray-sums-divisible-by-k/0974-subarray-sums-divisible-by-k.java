class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum =0;
        int rem = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int res = 0;
        
        for(int n: nums) {
            sum += n;
            rem = sum%k;
            if(rem<0) {
                rem += k;
            }
            if(hm.containsKey(rem)) {
                res += hm.get(rem);
                hm.put(rem, hm.get(rem)+1);
            } else {
                hm.put(rem, 1);
            }
        }
        
        return res;
    }
}