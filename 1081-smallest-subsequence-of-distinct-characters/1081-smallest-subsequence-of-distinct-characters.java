class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> st = new Stack<>();
        
        HashSet<Character> seen = new HashSet<>();
        
        HashMap<Character, Integer> lastOccur = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            lastOccur.put(s.charAt(i), i);
        }
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (!seen.contains(c)) {
                while(!st.isEmpty() && c < st.peek() && lastOccur.get(st.peek()) > i ) {
                    seen.remove(st.pop());
                }
                
                seen.add(c);
                st.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder(st.size());
        
        for(Character c: st) {
            sb.append(c.charValue());
        }
            
        return sb.toString();
            
    }
}