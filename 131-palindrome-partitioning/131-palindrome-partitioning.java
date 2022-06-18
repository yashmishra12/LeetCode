class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func (s, 0, path, res);

        return res;
    }
    
    public void func(String s, int startIndex, List<String> path, List<List<String>> res) {
        if(startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i=startIndex; i<s.length(); i++) {
            if(isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i+1));
                func(s, i+1, path, res);
                path.remove(path.size()-1);
            }
        }
    }
    
    
    boolean isPalindrome(String s, int low, int high) {
        while(low < high) {
            if(s.charAt(low) != s.charAt(high)) {return false;}
            low++;
            high--;
        }
        
        return true;
    }
}