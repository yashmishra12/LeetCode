class Solution {
    private final int MOD = (int)1e9+7;
    
    public int numberOfWays(String corridor) {
        int count = 0;

        int seatCount = 0;
        long ans = 1;
        
        for(int i=0; i<corridor.length();i++) {
            if (corridor.charAt(i)=='S') { seatCount++; count++;}
            
            if(seatCount==2) {
                int inCount = 1;
                i++;
                while(i<corridor.length() && corridor.charAt(i)=='P') { 
                    inCount++;
                    i++;
                }
                if (i==corridor.length()) {break;}

                ans= (ans*inCount)%MOD;
                seatCount=0;
                i--;
              }

            }
        
         if(count==0 || count%2 != 0) { return 0;}
        
        return (int)ans%MOD;
        }
}
