class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] check = new int[26];
        for(int i=0; i<sentence.length();i++) {
            char c = sentence.charAt(i);
            int index = c - 'a';
            check[index]++;
        }
        
        for(int i=0; i<check.length; i++) {
            if(check[i]==0) {return false;}
        }
        return true;
    }
}