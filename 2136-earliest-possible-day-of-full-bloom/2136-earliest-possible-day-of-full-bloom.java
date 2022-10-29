class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {

        //PlantTime is fixed, sort growtime in decending order to ensure the flower that needs more time to grow is planted first
        PriorityQueue<Plant> pg = new PriorityQueue<>((a,b) -> b.growTime - a.growTime);
        
        for (int i = 0; i < plantTime.length; i++) {
            Plant p = new Plant(plantTime[i], growTime[i]);
            pg.add(p);
        }
		
        int max = 0, cum = 0;

        while(!pg.isEmpty()){
             //find max time = cumulative plant time + current plant time + current growth time
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