class Solution {
    public boolean halvesAreAlike(String s) {
        int m = s.length()/2;
        s = s.toLowerCase();
        String a = s.substring(0, m);
        String b = s.substring(m);
        
        HashSet<Character> vowel = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int i1 = 0;
        int i2 = 0;
        
        for(char s1: a.toCharArray()){
            if(vowel.contains(s1)) {
                i1++;
            }
        }
        
         for(char s2: b.toCharArray()){
            if(vowel.contains(s2)) {
                i2++;
            }
        }
        
        return i1==i2;
    }
}