class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        //e.g. plant[2, 1, 1] grow[10, 4, 9]; combine the two array will get pg[[2,10], [1,4], [1,9]]

        //PlantTime is fixed, so we want to sort growtime in decending order to make sure the flower needs more time to grow can be planted first
        PriorityQueue<Plant> pg = new PriorityQueue<>((a,b) -> b.growTime - a.growTime);//decending order for growTime, will get [[2,10], [1,9], [1,4]]
        for (int i = 0; i < plantTime.length; i++) {
            Plant p = new Plant(plantTime[i], growTime[i]);
            pg.add(p);
        }
		
        
        int max = 0;
        int cum = 0;

        
        while(!pg.isEmpty()){
             //find max time = cumulative plant time + current plant time + current growth time
			//in this example, compare (2 + 10), (2 + 1 + 9) and (2 + 1 + 1 + 4), will find 12 is the max
            Plant p = pg.poll();
            max = Math.max(max, cum+p.plantTime+p.growTime);
            cum += p.plantTime; //plant time is fixed, keep track of the cumulated plant time;
        }
        return max;
    }
    
    class Plant {
        int plantTime;
        int growTime;
        Plant(int plantTime, int growTime) {
            this.plantTime = plantTime;
            this.growTime = growTime;
        }
    }
}