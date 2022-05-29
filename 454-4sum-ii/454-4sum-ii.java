class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int a: nums1) {
            for(int b: nums2) {
                hm.put(a+b, hm.getOrDefault(a+b, 0)+1);
            }
        }
        
        for(int c: nums3) {
            for(int d: nums4) {
                int x = -(c+d);
                res = res + hm.getOrDefault(x, 0); //if (c+d)=x then you need -x
            }
        }
        
        
        return res;
    }
}