class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = p.length();
        int[] arr = new int[128];
        
        for(char c: p.toCharArray()) {
            arr[(int)c]++;
        }
        
        for(int i = 0; i<=s.length()-n; i++) {
            String cur = s.substring(i,i+n);
            int[] arrCopy = Arrays.copyOf(arr, arr.length);
            boolean flag = false;
            
            for(char c: cur.toCharArray()) {
                arrCopy[(int)c]--;
                if(arrCopy[(int)c]<0) {
                    flag = true;
                    break;
                }
            }
            
            if(!flag) res.add(i);
            
        }
        
        return res;
    }
}