class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
          
        int[] indeg= new int[numCourses];
        HashMap<Integer, HashSet<Integer> > map = new HashMap<>();
        
        for(int[] a: prerequisites){
            int depCourse = a[0];
            int reqCourse = a[1];
            
            indeg[depCourse]++;
            HashSet<Integer> set = new HashSet<>();
            
            if(map.containsKey(reqCourse)) {
                if(!set.contains(depCourse)) {
                    set = map.get(reqCourse);
                    set.add(depCourse);
                    map.put(reqCourse, set);
                }
            }else {
                // set = map.get(reqCourse);
                set.add(depCourse);
                map.put(reqCourse, set);
            }
        }
            
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<indeg.length; i++) {
            if(indeg[i]==0) q.offer(i);
        }
        
        if(q.size()==0) return new int[]{};
        int count=0;
        int[] res = new int[numCourses];
        
        while(!q.isEmpty()) {
            int curr = q.remove();
            res[count] = curr;
            count++;
            HashSet<Integer> adj = map.get(curr);
            if(adj==null || adj.size()==0) continue;
            for(int a: adj) {
                indeg[a]--;
                if(indeg[a]==0) q.offer(a);
            }
        }
    
        boolean check =  count==numCourses;
        if(!check) return new int[] {};
        else return res;
        
    }
}