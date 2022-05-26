// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
        
//         HashMap<Integer, Integer> hm = new HashMap<>();
        
//         for(int a: nums) {
//             hm.put(a, hm.getOrDefault(a,0)+1);
//         }
        
//         int[] res = new int[k];
//         int i=0;
//         int[] kvPair = new int[2];
        
//         while(k>0) {
//             for(Map.Entry<Integer,Integer> a: hm.entrySet()) {
//                 int key = a.getKey();
//                 int freq = hm.get(key);
                
//                 if(freq>kvPair[1]) {
//                     kvPair[0] = key;
//                     kvPair[1] = freq;   
//                 }
//             }
            
//             res[i++] = kvPair[0];
//             hm.remove(kvPair[0]);
//             Arrays.fill(kvPair, 0);
//             k--;
//         }
        
//        return res; 
//     }
// }


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }
        
        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
          count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
          heap.add(n);
          if (heap.size() > k) heap.poll();    
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}