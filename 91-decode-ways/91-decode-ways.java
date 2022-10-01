class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int numDecodings(String s) {
        return helper(0, s);           
    }
    
    int helper(int index, String str) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        if(index == str.length()) {
            return 1;
        }
        
         if (str.charAt(index) == '0') {
            return 0; //can't begin with 0
        }

        if (index == str.length() - 1) {
            return 1;
        }
        
        int answer = helper(index+1, str); //next one string
        
        if(Integer.parseInt(str.substring(index, index+2)) <= 26) {
            answer += helper(index+2, str); //next two strings
        }
        
        memo.put(index, answer);
        
        return answer;
        
    }
}