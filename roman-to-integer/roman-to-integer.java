class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        
        int res = map.get(s.charAt(0));
        int val = 0;
        
        for(int i=1; i<s.length(); i++) {
            
            char cur = s.charAt(i);
            
            val = map.get(cur);
            
            res += val;
            
            int preVal = map.get(s.charAt(i-1));
            if(val>preVal) {
                res = res - preVal - preVal;
            }
        }
        
        return res;
    }
}
