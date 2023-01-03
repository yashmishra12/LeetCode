class Solution {
    public int minDeletionSize(String[] strs) {
        
        int res = 0;
        
        for(int i=0; i<strs[0].length(); i++){
            boolean unsorted = false;
            for(int w=1; w<strs.length; w++){
                
                char prevChar = strs[w-1].charAt(i);
                char curChar = strs[w].charAt(i);
                
                if(curChar-prevChar<0){
                    unsorted = true;
                    break;
                }
                
            }
            if(unsorted){
                res++;
            }
        }
        
        return res;
    }
}