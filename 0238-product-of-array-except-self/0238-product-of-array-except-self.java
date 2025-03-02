class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int suffixProduct = 1;
   
        product[0] = 1;

        for(int i=1; i<nums.length; i++) {
            product[i] = product[i-1] * nums[i-1];
        }


        for(int i=nums.length-2; i>=0; i--) {
            suffixProduct *= nums[i+1];
            product[i] *= suffixProduct;
        }


        return product;
        
    }
}