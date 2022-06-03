class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==1) return true;
        
        s = s.toLowerCase();
        ArrayList<Character> ch1 = new ArrayList<>();
        
        for(int i=0; i<s.length();i++) {
            if(Character.isLetterOrDigit(s.charAt(i))) {ch1.add(s.charAt(i));}
        }
        
        ArrayList<Character> ch2 = new ArrayList<>(ch1);
        Collections.reverse(ch1);
        
        for(int i=0;i<ch2.size(); i++) {
            if(ch1.get(i)!=ch2.get(i)) {return false;}
        }
        
        return true;
    }
}