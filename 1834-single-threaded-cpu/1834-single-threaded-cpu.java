class Solution {
    public int[] getOrder(int[][] tasks) {
        
        
        int sortedTasks[][] = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; ++i) {
            sortedTasks[i][0] = tasks[i][0]; // enque time
            sortedTasks[i][1] = tasks[i][1]; // processing time
            sortedTasks[i][2] = i;           // index 
        }
        
        Arrays.sort(sortedTasks, (a,b) -> Integer.compare(a[0], b[0]));
        int[] res = new int[tasks.length];
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( 
            (a,b) -> (a[1] == b[1] ? (a[2]-b[2]) : (a[1]-b[1]) //Order by lower PT. if PT is same, compare with index 
                     ));
            
        long curTime = 0;
        int taskIndx = 0, ansIndx = 0;
        
        
        while(taskIndx < tasks.length || !pq.isEmpty()) {
            
            if (pq.isEmpty() && curTime < sortedTasks[taskIndx][0]) {
                // When the heap is empty, try updating currTime to next task's enqueue time. 
                curTime = sortedTasks[taskIndx][0];
            }
            
             while (taskIndx < tasks.length && curTime >= sortedTasks[taskIndx][0]) { 
                pq.add(sortedTasks[taskIndx]);
                ++taskIndx;
            }
            
            int processTime = pq.peek()[1];
            int index = pq.peek()[2];
            pq.remove();
            
            curTime += processTime;
            res[ansIndx] = index;
            ansIndx++;
        }
        
        return res;

        
    }
}