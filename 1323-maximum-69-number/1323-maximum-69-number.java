class Solution {
    public int maximum69Number (int num) {

        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int i = 0;
        while(i<sb.length() && sb.charAt(i)=='9'){
            i++;
        }
        if(i==sb.length()){
            return num;
        }

        sb.setCharAt(i, '9');
        
        int res = Integer.parseInt(sb.toString());
        return res; 
    }
}