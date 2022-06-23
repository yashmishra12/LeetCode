class Solution {
    public boolean checkRecord(String s) {
        
        int a = 0;
        int l = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if(c=='P') {continue;}
            
            if(c=='A') {
                a++;
                if(a>1) {return false;}
            }
            else if(c=='L'){
                l = 1;
                while(i<s.length()-1 && s.charAt(i+1)=='L') {
                    i++;
                    l++;
                    if(l>2) {return false;}
                }
                l=0;
            }
        }
        return true;
    }
}