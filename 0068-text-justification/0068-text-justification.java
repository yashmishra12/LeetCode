class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int i = 0;
        
        while(i<words.length) {
            int wordCharCount = words[i].length();
            int j=i+1;
            int candidates = j-i-1;
            
            while(j<words.length && 
                  wordCharCount+candidates+words[j].length()+1 <= maxWidth) {
                
                wordCharCount += words[j].length();
                candidates++;
                j++;
            }
            
            int vacancy = maxWidth - wordCharCount;
            
            int atleast = candidates == 0 ? 0: vacancy/candidates;
            int extra = candidates == 0 ? 0: vacancy%candidates;
            
            if(j==words.length) {
                atleast = 1;
                extra=0;
            }
            
            StringBuilder sb = new StringBuilder();
            
            for(int k=i; k<j; k++){
                sb.append(words[k]);
                if(k==j-1) {
                    break;
                }
                
                for(int e=0; e<atleast;e++) {
                    sb.append(" ");
                }
                if(extra>0) {
                    sb.append(" ");
                    extra--;
                }
            }
            
            while(sb.length()<maxWidth) {
                sb.append(" ");
            }
            
            list.add(sb.toString());
            i=j;
            
        }
        
        return list;
    }
}