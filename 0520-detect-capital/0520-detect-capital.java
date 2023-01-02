class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1){
            return true;
        }
        

        if(word.equals(word.toUpperCase())) {
            return true;
        }
        
        if(word.equals(word.toLowerCase())){
            return true;
        }
        
        String afterFirst = word.substring(1);
        
        if(word.charAt(0)<65 || word.charAt(0)>90){
            return false;
        } 
           
        if(afterFirst.equals(afterFirst.toLowerCase())) {
                return true;
        }
   
        
        
        return false;
        
    }
}