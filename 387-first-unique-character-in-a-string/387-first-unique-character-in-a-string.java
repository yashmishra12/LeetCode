class Solution {
    public int firstUniqChar(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
         HashMap<Character, Integer> index = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            index.putIfAbsent(c, i);
            q.offer(c);
            
            while(!q.isEmpty()) {
                Character cur = q.peek();
                if(map.get(cur)==1) break;
                else q.remove();
            }
        }
        if(q.isEmpty()) return -1;
        
        int res = index.get(q.peek());
        return res;
    }
}