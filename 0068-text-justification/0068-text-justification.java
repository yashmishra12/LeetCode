class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int i = 0;
        
        while(i<words.length) {
            int wordCharCount = words[i].length(); //ek word to fit pakka hoga. 
            int j=i+1;
            int candidates = j-i-1;
            
            //Decide the numbers of words that can fit in one line
            
            while(j<words.length &&
                  //wordCharCount --> current word length
                  //words[j]+1 -----> new word plus its space
                  //candidates -----> pehle jitne words hai unka 1 space each
                wordCharCount+candidates+(1+words[j].length()) <= maxWidth) {
                
                    wordCharCount += words[j].length();
                    candidates++;
                    j++;
            }
            
            int vacancy = maxWidth - wordCharCount;
            
            int atleast = candidates == 0 ? 0: vacancy/candidates;
            int extra = candidates == 0 ? 0: vacancy%candidates;
            
            if(j==words.length) { //last line hai
                atleast = 1;
                extra=0;
            }
            
            StringBuilder sb = new StringBuilder();
            
            for(int k=i; k<j; k++){
                sb.append(words[k]);
                if(k==j-1) {
                    break;
                }
                
                for(int e=0; e<atleast;e++) { //required space daalo
                    sb.append(" ");
                }
                if(extra>0) { //extra space hai to daalo: ek-ek karke
                    sb.append(" ");
                    extra--;
                }
            }
            
            while(sb.length()<maxWidth) { //pad space on right to make length = maxWidth
                sb.append(" ");
            }
            
            list.add(sb.toString());
            i=j; //new line ab shuru karo. i will move to j. 
            
        }
        
        return list;
    }
}