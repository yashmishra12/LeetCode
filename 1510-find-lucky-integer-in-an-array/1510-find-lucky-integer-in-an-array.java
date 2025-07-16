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
    }
}