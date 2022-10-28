class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for(String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            // String key = String.join("", arr);
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
}