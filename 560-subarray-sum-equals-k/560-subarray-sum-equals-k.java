class Solution {
    public int subarraySum(int[] arr, int target) {
        int count=0, curSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0,1);
        
        for(int i=0; i<arr.length; i++) {
            curSum = curSum+arr[i];
            if(map.containsKey(curSum - target))
                    {count = count + map.get(curSum - target);}
            map.put(curSum, map.getOrDefault(curSum, 0)+1);
        }
        return count;
        
    }
}