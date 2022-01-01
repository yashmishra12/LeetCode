// class Solution {
//     public boolean isPalindrome(int x) {
//         if(x<0) return false;
        
//         Integer temp = new Integer(x);
        
//         String num = temp.toString();
        
//         int i = 0;
//         int j = num.length()-1;
        
//         while(i<j) {
//             if(num.charAt(i)!=num.charAt(j)) return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        
        int rev = 0;
        int rem = 0;
        int orig = x;
        
        while(x!=0) {
            rem = x%10;
            
            rev = rev*10 + rem;
            x = x/10;
        }
     
        return orig==rev;
    }
}
