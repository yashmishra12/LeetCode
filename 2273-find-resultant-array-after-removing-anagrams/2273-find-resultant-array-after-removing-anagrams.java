class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        
        if(words.length==1){
            return new ArrayList<String>(Arrays.asList(words[0]));
        }
        
        
        for(int i=1; i<words.length; i++) {
            String freqStart = freq(words[start]);
            String freqI = freq(words[i]);
            
            if( freqStart.equals(freqI) ) {
                continue;
            }else {
                ans.add(words[start]);
                start = i;
            }
        }
        
        ans.add(words[start]);
        
        String freqStart = freq(words[start]);
        String freqEnd = freq(words[words.length-1]);
        

        return ans;
    }
    
    
    private String freq(String word){
		int[] freq = new int[26];
		for(char c: word.toCharArray()){
			freq[c-'a']++;
		}

		StringBuilder ans = new StringBuilder();
		for(int el: freq){
			ans.append(el); 
		}

		return ans.toString();
	}
}