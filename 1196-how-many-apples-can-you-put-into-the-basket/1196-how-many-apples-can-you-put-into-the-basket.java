class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int weightLeft = 5000;
        int count = 0;
        
        for(int a: weight) {
            weightLeft = weightLeft - a;
            if(weightLeft < 0) {
                return count;
            } else {
                count++;
            }
        }
        
        return count;
    }
}