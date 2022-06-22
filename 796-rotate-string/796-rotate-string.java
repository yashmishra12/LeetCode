class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length() != goal.length()) {return false;}
        
        boolean check = (s+s).contains(goal);
        
        return check;
        
    }
}