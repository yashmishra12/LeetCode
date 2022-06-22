class Solution {
    public String reverseWords(String word) {
        word = word.trim();
		String[] arr = word.split(" ");
		
		String[] newArr = Arrays.stream(arr).filter(s -> s.length()>0).map(s -> s.trim()).toArray(String[]::new);

		Collections.reverse(Arrays.asList(newArr));
		
        String ans = String.join(" ", newArr);
		return ans;
        
    }
}