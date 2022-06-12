class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        
        int res = 0;
        int lastVal = Integer.MAX_VALUE;
        
        for(int i=0; i<s.length(); i++) {
            
            int curVal = hm.get(s.charAt(i));
            if (curVal>lastVal) {
                res += curVal - 2*lastVal;
            } 
            else {
                res += curVal;
            }
            lastVal = curVal;
        }
        
        return res;
        
    }
}