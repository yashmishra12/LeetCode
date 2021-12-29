// class Solution {
//     class SpecialBST {
//         int val;
//         int leftSubTreeSize;
        
//         SpecialBST left;
//         SpecialBST right;
        
//         SpecialBST(int val) {
//             this.val = val;
//             this.leftSubTreeSize=0;
//             left=null;
//             right=null;
//         }
        
//         void insert(int val,int index, List<Integer> res) {
//             insertHelper(val, index, res, 0);
//         }
        
//         void insertHelper(int val, int index, List<Integer> res, int valueToInsert) {
            
//             if(this.val>=val) {
//                 leftSubTreeSize++;
                
//                 if(left==null) {
//                     left = new SpecialBST(val);
//                     res.set(index, valueToInsert);
//                 } else {
//                     left.insertHelper(val, index, res, valueToInsert);
//                 }
                
                
//             }
//             else{
//                 valueToInsert+=leftSubTreeSize;
                
//                 if(this.val<val) valueToInsert++;
                               
//                 if(right==null) {
//                     right = new SpecialBST(val);
//                     res.set(index, valueToInsert);
//                 }
//                 else {
//                     right.insertHelper(val, index, res, valueToInsert);
//                 }
//             }

//         }
//     }
    
//     public List<Integer> countSmaller(int[] nums) {
        
//         List<Integer> res = new ArrayList<Integer>(Collections.nCopies(nums.length, 0));

//         int start = 0;
//         int end = nums.length-1;
        
//         SpecialBST bst = new SpecialBST(nums[end]);
//         res.set(end, 0);
        
//         for(int i=nums.length-2; i>=0; i--) {
//             bst.insert(nums[i], i, res);
//         }
        
//         return res;
        
//     }
    
    //TC: Avg=O(nlogn), WRST=O(n^2)
// }

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] indices = new int[n]; // record the index. we are going to sort this array
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        // sort indices with their corresponding values in nums, i.e., nums[indices[i]]
        mergeSort(indices, 0, n, result, nums);
        // change int[] to List to return
        List<Integer> resultToReturn = new ArrayList<Integer>(n);
        for (int i : result) {
            resultToReturn.add(i);
        }
        return resultToReturn;
    }

    private void mergeSort(int[] indices, int left, int right, int[] result, int[] nums) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(indices, left, mid, result, nums);
        mergeSort(indices, mid, right, result, nums);
        merge(indices, left, right, mid, result, nums);
    }

    private void merge(int[] indices, int left, int right, int mid, int[] result, int[] nums) {
        // merge [left, mid) and [mid, right)
        int i = left; // current index for the left array
        int j = mid; // current index for the right array
        // use temp to temporarily store sorted array
        List<Integer> temp = new ArrayList<Integer>(right - left);
        while (i < mid && j < right) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                // j - mid numbers jump to the left side of indices[i]
                result[indices[i]] += j - mid;
                temp.add(indices[i]);
                i++;
            } else {
                temp.add(indices[j]);
                j++;
            }
        }
        // when one of the subarrays is empty
        while (i < mid) {
            // j - mid numbers jump to the left side of indices[i]
            result[indices[i]] += j - mid;
            temp.add(indices[i]);
            i++;
        }
        while (j < right) {
            temp.add(indices[j]);
            j++;
        }
        // restore from temp
        for (int k = left; k < right; k++) {
            indices[k] = temp.get(k - left);
        }
    }
}