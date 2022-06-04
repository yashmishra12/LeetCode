class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        HashMap<String, List<String> > hm = new HashMap<>();
        
        for(String s: strings) {
            String hashKey = getHash(s);
            
            if(!hm.containsKey(hashKey)) {
                hm.put(hashKey, new ArrayList<>());
            }
            
            hm.get(hashKey).add(s);
        }
        List<List<String>> grp = new ArrayList<>();
        
        for(List<String> g: hm.values()) { grp.add(g); }
        
        return grp;
    }
    
    public static String getHash(String s) {
        char[] chars = s.toCharArray();
        
        StringBuilder sb = new StringBuilder();
    
        
        for(int i=1; i<chars.length;i++) {
            int diff = chars[i]-chars[i-1];

            int posDiff = diff+26; //diff can be pos. and then we are adding 26 to it. So, use modulo

            char finalChar = (char) (posDiff % 26 + 'a');
            
            sb.append(finalChar);
        }
        
        return sb.toString();
    }
    
    
    
}