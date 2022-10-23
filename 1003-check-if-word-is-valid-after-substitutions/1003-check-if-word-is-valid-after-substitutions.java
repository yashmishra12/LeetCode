class Solution {
    public boolean isValid(String s) {
        while(s.contains("abc"))
        {
            s=s.replaceFirst("abc","");
        }
        if(s.length()!=0)
        {
            return false;
        }
        return true;
    }
}