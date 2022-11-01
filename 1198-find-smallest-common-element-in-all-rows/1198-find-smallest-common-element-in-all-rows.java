class Solution {
    public int smallestCommonElement(int[][] mat) {
        
        TreeSet<Integer> s = new TreeSet<>();
        
        for(int i=0; i<mat[0].length; i++){
            s.add(mat[0][i]);
        }
        
        for(int i=1;i<mat.length; i++) {
            TreeSet<Integer> s2 = new TreeSet<>();
            for(int a: mat[i]){
                s2.add(a);
            }
            s.retainAll(s2);
        }
        
        if(s.size()==0) {
            return -1;
        }
        return s.first();
       
    }
}