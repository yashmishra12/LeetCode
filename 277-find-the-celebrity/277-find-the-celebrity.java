/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) st.push(i);
        
        while(st.size()>=2){
            int a = st.pop();
            int b = st.pop();
            
            if(knows(a, b)) st.push(b);
                else st.push(a);
        }
        
        int pot = st.pop();
        
        for(int i=0; i<n; i++) {
            if(i!=pot) {
                if (!knows(i, pot) || knows(pot, i)) return -1;
            }
        }
        
        return pot;
        
    }
}