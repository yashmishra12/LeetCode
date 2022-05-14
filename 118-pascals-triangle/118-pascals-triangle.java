class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        res.add(new ArrayList<>());
        res.get(0).add(1);
        
        for(int i=1; i<numRows; i++) {
            List<Integer> curRow= new ArrayList<>();
            List<Integer> prevRow = res.get(i-1);
            curRow.add(1);
            
            for(int k=1; k<i; k++) {curRow.add(prevRow.get(k-1) + prevRow.get(k));}
            
            curRow.add(1);
            
            res.add(curRow);
        }
        
        return res;
        
    }
}