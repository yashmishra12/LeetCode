class Solution {
    public int numSteps(String s) {
        if(s.length()==1) return 0;
        int ans=0;
        
        while(!s.equals("1")) {
            if(s.charAt(s.length()-1)=='1'){
                s = addOne(s);
                ans++;
            } else {
                s = s.substring(0, s.length()-1);
                ans++;
            }
        }
        return ans;
    }
    
  	public static String addOne(String s) {
        
		StringBuilder sb = new StringBuilder(s);
		
		int i = s.length()-1;
		boolean flag = false;
		
		while(i>=0) {
			if(sb.charAt(i)=='1') {
				sb.setCharAt(i, '0');
				i--;
			} else {
				sb.setCharAt(i, '1');
				flag=true;
				break;
			}
			
		}
		
		if(flag==false) {
            sb.insert(0, '1');
		}
		return sb.toString();
	}    
}
