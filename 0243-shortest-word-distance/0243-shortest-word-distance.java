class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        ArrayList<Integer> index1 = new ArrayList<>();
        ArrayList<Integer> index2 = new ArrayList<>();
        
        for(int i=0;i<wordsDict.length;i++) {
            String curWord = wordsDict[i];
            if(curWord.equals(word1)) {
                index1.add(i);
            }
            else if(curWord.equals(word2)) {
                index2.add(i);
            }
        }
        
        // Collections.sort(index1);
        // Collections.sort(index2);
        
        int i=0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        
        while(i<index1.size() && j<index2.size()) {
            int dist1 = index1.get(i);
            int dist2 = index2.get(j);
            min = Math.min(min, Math.abs(dist1-dist2));
            if(dist1>dist2){
                j++;
            }else if(dist2>dist1){
                i++;
            }
        }
        
        return min;
        
    }
}