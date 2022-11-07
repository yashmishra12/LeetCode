class Solution {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while(i<sb.length() && sb.charAt(i)=='9'){
            i++;
        }
        if(i==sb.length()){
            return num;
        }
        
//         int j = sb.length()-1;
//         while(j>=0 && sb.charAt(j)=='6'){
//             j--;
//         }
        
        sb.setCharAt(i, '9');
        // sb.setCharAt(j, '6');
        
        int res = Integer.parseInt(sb.toString());
        return res; 
    }
}