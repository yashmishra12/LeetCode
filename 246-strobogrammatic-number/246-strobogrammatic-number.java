class Solution {
    public boolean isStrobogrammatic(String num) {
            Map<Character, Character> hm = new HashMap<>(Map.of('0', '0', 
                                                                '1', '1', 
                                                                '6', '9', 
                                                                '8', '8', 
                                                                '9', '6')
                                                        );
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=num.length()-1; i>=0; i--) {
            char c = num.charAt(i);
            if(!hm.containsKey(c)) {return false;}
            
            sb.append(hm.get(c));
        }
        
        return num.equals(sb.toString());
    }
}