class Solution {
    public String multiply(String num1, String num2) {
        
        int n = num1.length();
        int m = num2.length();
        
        int[] res = new int[m+n];
        
        for(int i=n-1; i>=0; i--) {
            for (int j=m-1; j>=0; j--) {
                int mul = (int)(num1.charAt(i)-'0')*(int)(num2.charAt(j)-'0');
                int sum = res[i+j+1] + mul;
                
                res[i+j] += sum/10;
                res[i+j+1] = sum%10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int val: res) {
            if(sb.length()==0 && val==0) continue; //handles the first char of 0912
            sb.append(val);
        }
        
        if (sb.length()==0) return "0";
        else return sb.toString();
        
    }
}