class Solution {
   public boolean validWordSquare(List<String> words) {
	
      for (int i = 0, k = 0; i < words.size(); i++, k++)
        for (int j = 0; j < words.get(i).length(); j++)
			
            if (j >= words.size() || 
				k >= words.get(j).length() || 
				words.get(i).charAt(j) != words.get(j).charAt(k))
				return false;
	return true;
    }
}