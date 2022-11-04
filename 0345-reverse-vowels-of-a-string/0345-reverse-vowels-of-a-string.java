class Solution {
    // sb;
    public String reverseVowels(String s) {
        
        StringBuilder sb = new StringBuilder(s);

        HashSet<Character> set = new HashSet<>(Arrays.asList('a','A','e','E','i','I','o','O','u','U'));
        
        int r = 0;
        int l= sb.length()-1;
        // HashSet<Character> set = new HashSet<>();
        
        while(r<l){

            while(r<sb.length() && !set.contains(sb.charAt(r))){
                r++;
            }
            
            while(l>=0 && !set.contains(sb.charAt(l))){
                l--;
            }
 
            if(l<=r) {break;}
            sb = swap(sb,r++,l--);
         }
            
            

        
        return sb.toString();
    }
    
    public static StringBuilder swap(StringBuilder sb, int i, int j){
        char c1 = sb.charAt(i);
        char c2 = sb.charAt(j);
        sb.setCharAt(i, c2);
        sb.setCharAt(j, c1);
        return sb;
    }
}