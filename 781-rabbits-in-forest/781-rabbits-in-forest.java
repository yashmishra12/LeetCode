class Solution {
    public int numRabbits(int[] answers) {
		int res = myFunction(answers);
		return res;
	}

	public static int myFunction(int[] arr){
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i: arr) {
			hm.put(i, hm.getOrDefault(i, 0)+1);
		}

		int res = 0;

		for(Map.Entry <Integer, Integer> e: hm.entrySet()){
			double groupSize = e.getKey()+1;
			double popFreq = e.getValue();

			res += Math.ceil((double)popFreq/groupSize)*groupSize; 
		}

		return res;
	}
}