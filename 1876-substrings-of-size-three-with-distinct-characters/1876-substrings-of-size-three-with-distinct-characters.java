class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length()<3)
        {return 0;}

    int k=3;
    StringBuilder str=new StringBuilder(s);
    int count=0;

    char d=str.charAt(0),e=str.charAt(1),f=str.charAt(2);
    if(d!=e && e!=f && f!=d){
        count++;
    }
        
    for(int i=k;i<s.length();i++){            
        str.append(s.charAt(i));
        str.deleteCharAt(0);
        
        char a=str.charAt(0),b=str.charAt(1),c=str.charAt(2);
        if(a!=b && b!=c && c!=a)
        {count++;}          
    }
    return count;
    }
}