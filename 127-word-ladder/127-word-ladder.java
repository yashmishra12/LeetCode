class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>(wordList);
        if(!hs.contains(endWord)) {return 0;}
        
        Queue<String> q = new LinkedList<>();
        int level = 1;
        
        q.offer(beginWord);
        
        while(!q.isEmpty()) {
            int size = q.size();
            level ++;
            
            for(int i=0; i<size; i++) { //takes one word at a time from Queue
                String curWord = q.poll();
                char[] wordChar = curWord.toCharArray();
                
                for(int j=0; j<wordChar.length; j++) { //takes one letter at a time from word
                    char origChar = wordChar[j];
                    
                    for(char c='a'; c<='z'; c++) { //puts 'a'-->'z' in place of the letter
                        if (wordChar[j]==c) {continue;} //you get the same word
                        
                        wordChar[j]=c;
                        String newWord = String.valueOf(wordChar);
                        if(newWord.equals(endWord)) {return level;}
                        
                        if(hs.contains(newWord)) {
                            q.offer(newWord);
                            hs.remove(newWord);
                        }
                    }
                    
                    wordChar[j] = origChar; //restore back the letter and hence the word
                }
            }    
        }
        
        return 0;
        
    }
}