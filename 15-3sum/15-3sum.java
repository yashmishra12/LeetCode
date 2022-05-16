// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {  
//         if (nums.length<3) return new ArrayList<List<Integer>>();
//         Set<String> set = new HashSet<String>();

//         Arrays.sort(nums);
        
//         ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
//         int i = 0, j = 0;
        
//         for(int p=0; p<nums.length-2; p++) {
//             i = p+1;
//             j = nums.length-1;
            
//             while(i<j){
//                  int curSum = nums[p]+nums[i]+nums[j];
//                 String pot = stringify(nums[p],nums[i],nums[j]);
            
//                 if(curSum==0 && !set.contains(pot) ){
//                     ArrayList<Integer> ans = new ArrayList<>();
//                     ans.add(nums[p]);
//                     ans.add(nums[i++]);
//                     ans.add(nums[j--]);
//                     res.add(ans);
//                     set.add(pot);
                    
//                 }
//                 else if(curSum<0) {
//                     i++;
//                 } else {
//                     j--;
//                 }
//             }
//         }
        
//         return res;
//     }
    
//     public static String stringify(int a, int b, int c) {
//         return a+","+b+","+c;
//     }
// }
    
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         
        if (nums.length<3) return new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);
        
        int i = 0, j = 0;
        
        for(int p=0; p<nums.length-2; p++) {
            i = p+1;
            j = nums.length-1;
            
            while(i<j){
                 int curSum = nums[p]+nums[i]+nums[j];
            
                if(curSum==0 ){
                    set.add(Arrays.asList(nums[p], nums[i++], nums[j--]));
                }
                else if(curSum<0)  {i++;}
                else  {j--;}
            }
        }
        
        return new ArrayList<>(set);
    }
}
