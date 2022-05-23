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
		char[] ch = s.toCharArray();
	
		int i = s.length()-1;
		
		boolean flag = false;
		while(i>=0) {
			if(ch[i]=='1') {
				ch[i]= '0';
				i--;
			} else {
				ch[i]= '1';
				flag=true;
				break;
			}
			
		}
		
		if(flag==false) {
			char[] ch2 = new char[s.length()+1];
			Arrays.fill(ch2, '0');
			ch2[0]='1';
			return String.valueOf(ch2);
		}
		
		
		return String.valueOf(ch);
		
	}
    
}