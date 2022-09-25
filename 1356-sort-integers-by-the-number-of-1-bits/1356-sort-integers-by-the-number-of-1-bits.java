class Solution {
    public int[] sortByBits(int[] arr) {
        
        if(arr.length<2) {
            return arr;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
        
        for(int n: arr) {
            Integer oneCount = numOnes(n);
            tm.putIfAbsent(oneCount, new ArrayList<Integer>());
            tm.get(oneCount).add(n);
        }
        
        for(Map.Entry <Integer, ArrayList<Integer>> entry: tm.entrySet()) {
            Collections.sort(entry.getValue());
            res.addAll(entry.getValue() );
        }
        
        int[] finalRes = new int[res.size()];
        for(int i=0; i<finalRes.length; i++){
            finalRes[i] = res.get(i);
        }
        
        return finalRes;
        
    }
    
public int numOnes(int n) {
    int count = 0;
    
    while(n > 0) {
      n = n & (n-1);
      count++;
    }
    return count;
  } 
}