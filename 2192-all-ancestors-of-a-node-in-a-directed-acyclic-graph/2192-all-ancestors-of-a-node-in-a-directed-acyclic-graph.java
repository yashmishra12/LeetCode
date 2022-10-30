class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] indeg = new int[n];
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        List<TreeSet<Integer>> res = new ArrayList<>(n);
        
        for(int i=0;i<n;i++) {
            res.add(new TreeSet<>());
        }
        
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            
            indeg[to]++;
            
            if(hm.containsKey(from)) {
                hm.get(from).add(to);
            }else {
                ArrayList<Integer> hs = new ArrayList<>();
                hs.add(to);
                hm.put(from, hs);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<indeg.length;i++) {
            if(indeg[i]==0) {
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {
            int curNode = q.poll();
            List<Integer> value = hm.get(curNode);
            if(value==null) continue;
            for(Integer a: value){
                indeg[a]--;
                TreeSet<Integer> arr = res.get(a);
                arr.add(curNode);
                arr.addAll(res.get(curNode));
                res.set(a, arr);
                if(indeg[a]==0){
                    q.offer(a);
                }
            }
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        

        for(int i=0; i<res.size();i++){
            TreeSet<Integer> ts = res.get(i);
            List<Integer> list = new ArrayList<>(ts);
            answer.add(list);
        }
        
        return answer;
    }
}