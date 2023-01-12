// class Solution {
//     public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
//         Map<Integer, List<Integer>> adj = new HashMap<>();
        
//         for(int[] edge: edges) {
//             int a = edge[0], b = edge[1];
            
//             if(!adj.containsKey(a)) {
//                 adj.put(a, new ArrayList<Integer>());
//             }
            
//             if(!adj.containsKey(b)){
//                 adj.put(b, new ArrayList<Integer>());
//             }
            
//             adj.get(a).add(b);
//             adj.get(b).add(a);
//         }
        
//         return dfs(0, -1, adj, hasApple);
//     }
    
//     public int dfs(int node, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
//         if (!adj.containsKey(node)) {
//             return 0;
//         }
        
//         int totalTime = 0, childTime = 0;
        
//         for(int child: adj.get(node)) {
//             if(child==parent) {
//                 continue;
//             }
            
//             childTime = dfs(child, node, adj, hasApple);
            
//             if(childTime>0 || hasApple.get(child)) {
//                 totalTime += childTime + 2;
//             }
//         }
//         return totalTime;
//     }
// }
class Solution {
	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		List<List<Integer>> adjacencyList = new ArrayList<>();

		for(int i=0;i<n;i++){
			adjacencyList.add(new ArrayList<Integer>());
		}
        
		boolean visited[] = new boolean[n];

		for(int[] e:edges){
			adjacencyList.get(e[0]).add(e[1]);
			adjacencyList.get(e[1]).add(e[0]);
		}

		return dfs(adjacencyList,visited,hasApple,0);
	}

	private int dfs(List<List<Integer>> adjacencyList,boolean[] visited,List<Boolean> hasApple,int index)
	{
		int appleCollectedTime = 0;

		visited[index] = true;

		for(int i:adjacencyList.get(index))
		{
			if(!visited[i]){
				appleCollectedTime += dfs(adjacencyList,visited,hasApple,i);
			}
		}

		if(index == 0){
			return appleCollectedTime;
		}

		if(hasApple.get(index) || appleCollectedTime >0) {
			appleCollectedTime += 2;
		}


		return appleCollectedTime;
	}

}