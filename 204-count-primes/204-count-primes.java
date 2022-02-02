class Solution {
    public int countPrimes(int n) {
       if (n<=2) return 0;
        
        boolean[] numbers = new boolean[n];
        
        for(int p=2; p<=(int)Math.sqrt(n); p++) {
            if(numbers[p]==false) {
                for(int j=p*p; j<n; j=j+p) 
                    numbers[j] = true; //primes smaller than p^2 would be covered by numbers smaller than p
            }    
        }
        
        int res = 0;
        
        for(int i=2; i<n; i++) 
        {
            if(!numbers[i]) res++;
        }
        
        return res;
    }
}