class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        
        HashSet<Character> s1  = new HashSet<>();
        HashSet<String> s2 = new HashSet<>();
        
        
        if(pattern.length() != words.length) return false;
        
        if(pattern.length()==1 && words.length==1) return true;
        
        for(int i=0; i<pattern.length(); i++) {
            
            Character char1 = pattern.charAt(i);
            String word = words[i];
            
            s1.add(char1);
            s2.add(word);
            
            if(!map.containsKey(char1)) {
                map.put(char1, word);
            } else {
                
                String curWord = map.get(char1);
                if(!curWord.equals(word)) return false;
            }
        }
        
        return s1.size()==s2.size() ? true : false;
    }
}