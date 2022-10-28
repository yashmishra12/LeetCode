class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for(String str: strs){
            int[] arr = convertor(str);
            String key = Arrays.toString(arr);
            if(hm.containsKey(key)){
                hm.get(key).add(str);
            }else {
                ArrayList<String> arr2 = new ArrayList<>();
                arr2.add(str);
                hm.put(key, arr2);
            }
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        
        for(String key: hm.keySet()){
            res.add(hm.get(key));
        }
        
        return res;
    }
    
    private int[] convertor(String s) {
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        return arr;
    }
}