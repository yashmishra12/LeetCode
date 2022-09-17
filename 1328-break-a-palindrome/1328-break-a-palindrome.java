// class Solution {
//     public String breakPalindrome(String palindrome) {
//         if(palindrome.length()==1){ return ""; }
        
//         char[] arr = palindrome.toCharArray();
//         boolean flag = false;
        
//         for(int i=0; i<arr.length/2; i++) {
//             char curChar = arr[i];
//             if (curChar != 'a') {
//                 arr[i]='a';
//                 flag=true;
//                 break;
//             }
//         }
        
//         StringBuilder sb = new StringBuilder();

//         for(char c: arr) { sb.append(c); }
        
//         if (flag==true) {
//             return sb.toString();
//         }
//         else {
//             arr[arr.length-1]='b';
//             sb.replace(arr.length-1,arr.length, "b");
//             return sb.toString();
//         }
//     }
// }

class Solution {
    public String breakPalindrome(String palindrome) {
        int length = palindrome.length();
        if (length == 1) { 
            return "";
        }
        // Strings are immutable in Java, convert it into a char array
        char[] palindromeArray = palindrome.toCharArray();
        
        for (int i = 0; i < length / 2; i++) {
            if (palindromeArray[i] != 'a') {
                palindromeArray[i] = 'a';
                return String.valueOf(palindromeArray);
            }
        }
        
        palindromeArray[length - 1] = 'b';
        return String.valueOf(palindromeArray);
    }
}