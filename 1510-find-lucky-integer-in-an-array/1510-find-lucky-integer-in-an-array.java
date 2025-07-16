class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int a : arr) {
            m.put(a, m.getOrDefault(a, 0) + 1);
        }

        int answer = -1;

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if (key == val && key > answer) {
                answer = key;
            }
        }

        return answer;

        // Arrays.sort(arr);
        // int frq = 1;

        // for(int i=arr.length-1; i>=0; i--) {
        //     frq = 1;
        //     int curr = arr[i];
        //     while(i!=0 && arr[i] == arr[i-1]) {
        //         frq++;
        //         i--;
        //     }

        //     if(frq == curr)  {
        //         return curr;
        //     }
        // }

        // return -1;
    }
}