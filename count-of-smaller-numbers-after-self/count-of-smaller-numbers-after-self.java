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
    int[] count;
     public List<Integer> countSmaller(int[] nums) {
         count = new int[nums.length];
         List<Integer> res = new ArrayList<>();
         int[] index = new int[nums.length];
         for(int i=0; i<index.length; i++) {
             index[i] = i;
         }
         
         split(nums, index, 0, nums.length-1);
         
         for(int i=0; i<nums.length; i++) res.add(count[i]);
         
         return res;
     }
    
    public void split(int[] arr, int[] index, int l, int r) {
        if(l<r) {
            int mid = l + (r-l)/2;
            split(arr, index, l, mid);
            split(arr, index, mid+1, r);
            merge(arr, index, l, mid, r);
        }
    }
    
    public void merge(int[] arr, int[] index, int l, int mid, int r) {
        int n1 = mid-l+1;
        int n2 = r-mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for(int i =0; i<n1; i++) L[i] = index[l+i]; //NOTE: YOU ARE STORING INDEX
        for(int i =0; i<n2; i++) R[i] = index[mid+1+i];
        
        int i=0, j = 0, k=l, rightCount=0;
        
        while(i<n1 && j<n2) {
            if(arr[L[i]]<= arr[R[j]]) { //no jumping. Simple merging. 
                index[k] = L[i]; //smaller no index goes to index--> for future merges
                count[L[i]] += rightCount; 
                i++;
            }           //PERSPECTIVE CHANGE: instead of looking at right jumps. See how many no. from right went to arr in place of you. 
            else // O...o --> jump
            {// 7,9...1,2,3,8 ---> 9 will jump atleast as many jumps as 7. 
                index[k] = R[j]; //O..o --> bigNo. jumped. left is smaller
                rightCount++; //increase jumpCount for the next number when the current number if jumping right. He will have to jump atleast these many times. 
                j++;
            }
            k++;
        }
        
        while(i<n1) {
            index[k] = L[i];
            count[L[i]] += rightCount;
            i++;
            k++;
        }
        
        while(j<n2) {
             index[k] = R[j];
                rightCount++;
                j++;
            k++;
        }
    }
}
