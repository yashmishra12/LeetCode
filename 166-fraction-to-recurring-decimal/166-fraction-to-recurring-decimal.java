class Solution {
    public String fractionToDecimal(int num, int den) {
        if (num==0) {return "0";}
        
        StringBuilder fraction = new StringBuilder();
        
        if(num<0 ^ den <0) { // If either one is negative (not both)
            fraction.append("-");
        }
        
        long dividend = Math.abs(Long.valueOf(num));
        long divisor = Math.abs(Long.valueOf(den));
        
        fraction.append(String.valueOf(dividend/divisor));
        long rem = dividend%divisor;
        
        if(rem==0) {
            return fraction.toString();
        }
        
        fraction.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        
        while(rem!=0) {
            if(map.containsKey(rem)) {
                fraction.insert(map.get(rem), "(");
                fraction.append(")");
                break;
            }
            map.put(rem, fraction.length());
            rem *= 10;
            fraction.append(String.valueOf(rem/divisor));
            rem = rem%divisor;
        }
        return fraction.toString();
    }
}