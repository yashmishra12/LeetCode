class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new LinkedHashMap<>();
        for(String s:strs){
            char[] charArray=s.toCharArray();
            Arrays.sort(charArray);
            String key=Arrays.toString(charArray);
            List<String> subList=map.getOrDefault(key,new ArrayList());
            subList.add(s);
            map.put(key,subList);
        }
        List<List<String>> result=new ArrayList<>();
        for(List<String> value:map.values()){
            result.add(value);
        }
        return result;
    }
}