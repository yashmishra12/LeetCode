class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        
        for(int i=0; i<26; i++) {
            parent[i]=i; //every char is its own parent
        }
        
        for(String eq: equations) {
            
            if(eq.charAt(1)=='=') {
                int par1 = getParent(eq.charAt(0)-'a', parent);
                int par2 = getParent(eq.charAt(3)-'a', parent);
                
                if(par1 != par2) {
                    parent[par2] = par1;
                }
            }
        }
        
         
        for(String eq: equations) {
            
            if(eq.charAt(1)=='!') {
                int par1 = getParent(eq.charAt(0)-'a', parent);
                int par2 = getParent(eq.charAt(3)-'a', parent);
                
                if(par1 == par2) {
                    return false;
                }
            }
        }
        
        
        return true;
    }
    
    public int getParent(int index, int[] parent) {
        if(parent[index]==index) {
            return index;
        }
        
        return getParent(parent[index], parent);
    }
}