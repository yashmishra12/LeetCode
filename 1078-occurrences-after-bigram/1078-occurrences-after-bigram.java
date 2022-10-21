class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> res = new ArrayList<>();
        String[] arr = text.split(" ");
        
        for(int i=2; i<arr.length;i++) {
            if (arr[i-2].equals(first) && arr[i-1].equals(second)) {
                res.add(arr[i]);
            }
        }
        
        return res.toArray(new String[res.size()]);
    }
}