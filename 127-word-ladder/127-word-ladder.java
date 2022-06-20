class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>(wordList);
        if(!hs.contains(endWord)) {return 0;}
        
        Queue<String> q = new LinkedList<>();
        int level = 1;
        
        q.offer(beginWord);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0; i<size; i++) {
                String curWord = q.poll();
                char[] wordChar = curWord.toCharArray();
                
                for(int j=0; j<wordChar.length; j++) {
                    char origChar = wordChar[j];
                    
                    for(char c='a'; c<='z'; c++) {
                        if (wordChar[j]==c) {continue;} //you get the same word
                        
                        wordChar[j]=c;
                        String newWord = String.valueOf(wordChar);
                        if(newWord.equals(endWord)) {return level+1;}
                        
                        if(hs.contains(newWord)) {
                            q.offer(newWord);
                            hs.remove(newWord);
                        }
                    }
                    
                    wordChar[j] = origChar;
                }
            }
            level ++;
        }
        return 0;
        
    }
}