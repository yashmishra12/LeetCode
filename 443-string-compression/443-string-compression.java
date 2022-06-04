class Solution {
    public int compress(char[] chars) {
            
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c: chars) {
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        
        int count=0;
        
        for(int i=0; i<chars.length; i++) {
            int val = 1;
            while(i != chars.length-1 && chars[i]==chars[i+1]) {
                i++;
                val++;
            }
            
            chars[count++] = chars[i];
            if(val==1) {continue;}
            
            String st = String.valueOf(val);
            for(int k=0; k<st.length(); k++) {chars[count++] = st.charAt(k);}
        }
        
        return count;
        
    }
}