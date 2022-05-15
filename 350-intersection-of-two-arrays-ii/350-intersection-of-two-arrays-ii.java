class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        
       int i = 0, k=0;
        
        while(i<nums1.length && k<nums2.length) {
            if(nums1[i]<nums2[k]) i++;
            else if (nums1[i]>nums2[k]) k++;
            else {
                res.add(nums1[i]);
                i++;
                k++;
            }
        }
        
        int[] answer = new int[res.size()];
        
        for(int j=0; j<answer.length; j++ ){
            answer[j] = res.get(j);
        }
        return answer;
        
    }
}