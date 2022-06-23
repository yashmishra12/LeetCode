class Solution {
    long MOD = 1000000007;
    
    public int checkRecord(int n) {
        long a0l0 = 1;
        long a0l1 = 0;
        long a0l2 = 0;
        long a1l0 = 0;
        long a1l1 = 0;
        long a1l2 = 0;
        
        for(int i=0; i<n; i++) {
            long new_a0l0 = (a0l0 + a0l1 + a0l2) % MOD;
            long new_a0l1 = a0l0;
            long new_a0l2 = a0l1;
            long new_a1l0 = (a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % MOD;
            long new_a1l1 = a1l0;
            long new_a1l2 = a1l1;
            a0l0 = new_a0l0;
            a0l1 = new_a0l1;
            a0l2 = new_a0l2;
            a1l0 = new_a1l0;
            a1l1 = new_a1l1;
            a1l2 = new_a1l2;
            
        }
        
        return (int)((a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % MOD);
    }
}