class Solution {
    public boolean confusingNumber(int n) {
        boolean allZero = true, allOnes = true;
        String number = n+"";
        StringBuilder sb = new StringBuilder(number);
        HashMap<Character, Character> mp = new HashMap<>();
        mp.put('0','0');
        mp.put('1','1');
        mp.put('6','9');
        mp.put('8','8');
        mp.put('9','6');
        
          
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);

            if(c=='2' || c=='3' || c=='4' || c=='5' || c=='7'){
                return false;
            }
            Character cNew = mp.get(c);
            sb.setCharAt(i, cNew);
        }
            
  
        
        String sNew = sb.reverse().toString();
        if(sNew.equals(number)){
            return false;
        }
        return true;
    }
}