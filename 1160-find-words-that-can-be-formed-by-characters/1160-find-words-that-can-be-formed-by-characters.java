class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] avl = new int[26];
        for(char c: chars.toCharArray()) {
            avl[c-'a']++;
        }
        
        int sum =0;
        for(String word: words) {
            boolean flag = true;
            int[] cv = Arrays.copyOfRange(avl, 0, avl.length);
            for(char c: word.toCharArray()){
               if(--cv[c-'a']<0) {
                   flag = false;
                   break;
               } 
            }
            if (flag) { sum += word.length();}
            
        }
        
        return sum;
    }
}