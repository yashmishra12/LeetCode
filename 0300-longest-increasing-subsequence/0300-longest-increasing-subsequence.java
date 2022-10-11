class Solution {
    public int lengthOfLIS(int[] array) {
        if(array.length==1) {return 1;}
        int[] length = new int[array.length];
		length[0]=1;
		
        int overallMax = 0;
		
		for(int i=1;i<array.length; i++) {
			int max = 0;
            
			for(int j=0; j<i; j++) {
				
                if(array[j] < array[i]) {
                    if(length[j]>max){
					    max = length[j];
				    }
                }
				
			}
			length[i]=max+1;
            
			overallMax = Math.max(length[i], overallMax);

		}
        
        return overallMax;
    }
}