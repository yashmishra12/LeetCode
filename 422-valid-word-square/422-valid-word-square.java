class Solution {
   public boolean validWordSquare(List<String> words) {
	
       int k = 0;
       int n = words.size();
      for (int i = 0; i < words.size(); i++) {
        for (int j = 0; j < words.get(i).length(); j++) {
            if (j >= n || 
                k >= words.get(j).length() || 
				words.get(i).charAt(j) != words.get(j).charAt(k)
               ) {
                return false;
            }
        }
          k++;
      }
			      
	return true;
    }
}