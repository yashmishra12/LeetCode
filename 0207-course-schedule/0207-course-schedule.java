class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        int[] indeg = new int[numCourses];
        
        for(int[] node: prerequisites){
            int pre = node[1];
            int post = node[0];
            
            indeg[post]++;
            
            if(hm.containsKey(pre)) {
                HashSet<Integer> set = hm.get(pre);
                set.add(post);
                hm.put(pre, set);
            }else {
                HashSet<Integer> set = new HashSet<>();
                set.add(post);
                hm.put(pre, set);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++) {
            if(indeg[i]==0) {
                q.offer(i);
            }    
        }
        int counter = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            counter++;
            HashSet<Integer> set = hm.get(cur);
            if(set==null || set.size()==0) {continue;}
            
            for(Integer a: set){
                indeg[a]--;
                if(indeg[a]==0){q.offer(a);}
            }
        }
        
        return counter==numCourses;
    }
}