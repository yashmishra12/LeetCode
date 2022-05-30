class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int n: nums) {
            if(n>0) {pos.add(n);}
            else {neg.add(n);}
        }
        
        int i=0, j=0;
        
        while(i<pos.size()) {
         res.add(pos.get(i++));   
        res.add(neg.get(j++));
        }
        
        for(int k=0; k<res.size();k++) {
            nums[k] = res.get(k);
        }
        
        return nums;
    }
}