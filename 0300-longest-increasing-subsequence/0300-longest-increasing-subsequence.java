class Solution {
    public int lengthOfLIS(int[] array) {
        if(array.length==1) {return 1;}
        int[] length = new int[array.length];
		Arrays.fill(length, 1);
		
		int max = 0;
		
		for(int i=1;i<array.length; i++) {
			int curNum = array[i];
			
			for(int j=0; j<i; j++) {
				int otherNum = array[j];
				
				if(otherNum<curNum && length[j]+1 > length[i]){
					length[i] = length[j]+1;
				}
			}
			
			max = Math.max(max, length[i]);

		}
        
        return max;
    }
}