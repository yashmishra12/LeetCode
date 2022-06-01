class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        
        for(String word: strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            
            if(hm.containsKey(sortedWord)) {
                hm.get(sortedWord).add(word);
            } else {
                hm.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
            }
        }
        
        return new ArrayList<>(hm.values());
    }
}