class Solution {
    public String getHint(String secret, String guess) {
        
        int[] arr = new int[10];
        int bull=0, cows=0;
        
        for(int i=0; i<guess.length();i++) {
            int a = secret.charAt(i)-'0';
            int b = guess.charAt(i)-'0';
            
            if(a==b) bull++;
            else {
                
                if(arr[a]<0)cows++;
                if(arr[b]>0)cows++;
                
                arr[a]++;
                arr[b]--;
            }
        }
        
        int sum = Arrays.stream(arr).sum();
        
        // int cows = secret.length() - bull - sum;
        
        StringBuilder sb = new StringBuilder();
        sb.append(bull);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        
        return sb.toString();
        
    }
}