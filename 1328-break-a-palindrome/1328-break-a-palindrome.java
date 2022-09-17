class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1){ return ""; }
        
        char[] arr = palindrome.toCharArray();
        boolean flag = false;
        
        for(int i=0; i<arr.length/2; i++) {
            char curChar = arr[i];
            if (curChar != 'a') {
                arr[i]='a';
                flag=true;
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();

 for(char c: arr) { sb.append(c); }
        
        if (flag==true) {
                
           
            return sb.toString();
        }
        else {
            arr[arr.length-1]='b';
            sb.replace(arr.length-1,arr.length, "b");
            return sb.toString();
        }
    }
}