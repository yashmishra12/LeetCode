class Solution {
    HashMap<String, List<String>> map = new HashMap<>();
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        createPrefixMap(words);
        
        for(int i=0; i<words.length; i++) {
            LinkedList<String> list = new LinkedList<>();
            list.add(words[i]);
            
            backTrack(1, list, result, words[i].length());
        }
        return result;
    }
    
    void backTrack(int step, LinkedList<String> list, List<List<String>> result, int n) {
        if(list.size() == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(String word: list) {
            sb.append(word.charAt(step));
        }
        
        String prefix = sb.toString();
        List<String> wordList = map.getOrDefault(prefix, new ArrayList<>());
        
        for(String word: wordList){
            list.add(word);
            backTrack(step+1, list, result, n);
            list.removeLast();
        }
    }
    
    
    void createPrefixMap(String[] words) {
        for(String word: words) {
            for(int i=0; i<word.length();i++) {
                String prefix = word.substring(0,i);
                map.putIfAbsent(prefix, new ArrayList<>());
                
                List<String> list = map.get(prefix);
                list.add(word);
            }
        }
    }
}