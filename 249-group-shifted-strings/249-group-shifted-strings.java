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
        
        int shift = chars[0];
        
        for(int i=0; i<chars.length;i++) {
            chars[i] = shiftLetter(chars[i], shift);
        }
        
        return String.valueOf(chars);
    }
    
    public static char shiftLetter(char c, int s){
        
        int diff = (c-s);
        int posDiff = diff+26;
        char finalChar = (char) (posDiff % 26 + 'a');
        
        return finalChar; 
    }
    
    
}