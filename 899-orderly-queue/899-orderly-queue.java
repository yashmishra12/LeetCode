class Solution {
    public String orderlyQueue(String s, int k) {
        if(s.length()==1){
            return s;
        }
        if(k>1){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            
            return String.valueOf(c);
        }
        
        StringBuilder ans = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            StringBuilder tmp = new StringBuilder(s.substring(i)+s.substring(0,i));
            if(tmp.compareTo(ans)<0){
                ans = tmp;
            }
        }
        
        
        return ans.toString();
    }
}