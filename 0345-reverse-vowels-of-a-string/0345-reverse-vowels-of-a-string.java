class Solution {
    StringBuilder sb;
    public String reverseVowels(String s) {
        ArrayList<Integer> arr = new ArrayList<>();
        
     for(int i=0; i<s.length();i++){
         char c = s.charAt(i);
         if (c=='a' || c=='e' ||  c=='i' ||  c=='o' ||  c=='u' ||
            c=='A' || c=='E' ||  c=='I' ||  c=='O' ||  c=='U') {
             arr.add(i);
         }
     }   
        
        sb = new StringBuilder(s);
        
        int right = 0;
        int left= arr.size()-1;
        while(right<left){
            int k1 = arr.get(right++);
            int k2 = arr.get(left--);
            swap(sb,k1,k2);
        }
        
        return sb.toString();
    }
    
    public static void swap(StringBuilder sb, int i, int j){
        char c1 = sb.charAt(i);
        char c2 = sb.charAt(j);
        sb.setCharAt(i, c2);
        sb.setCharAt(j, c1);
    }
}