class Solution {
    public boolean wordPattern(String pattern, String s) {
       
        
        HashMap<Character, String> charToString = new HashMap<>();
        HashMap<String, Character> stringToChar = new HashMap<>();
        
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        
        for(int i=0; i<pattern.length(); i++){
            char curChar = pattern.charAt(i);
            String word = arr[i];
            
            if(charToString.containsKey(curChar) && !charToString.get(curChar).equals(word)){
                return false;
            }
             if(stringToChar.containsKey(word) && stringToChar.get(word)!=(curChar)){
                return false;
            }
            
            charToString.put(curChar, word);
            stringToChar.put(word, curChar);
        }
        
        return true;
        
        
    }
}