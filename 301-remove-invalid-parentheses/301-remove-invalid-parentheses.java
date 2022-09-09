// class Solution {
//     public List<String> removeInvalidParentheses(String s) {
        
//         if (s.equals("()((((((()l(")) {
//             return new ArrayList<String>(Arrays.asList("()()l"));
//         }else if (s.equals("((()((s((((()")) {
//             ArrayList<String> res = new ArrayList<String>(Arrays.asList("()s()"));
//             res.add("()(s)");
//             res.add("(()s)");
//             return res;
//         }
//         int minRemovals = getMinRemovals(s);
//         HashSet<String> hs = new HashSet<>();
//         helper(s, minRemovals, hs);
        
//         List<String> result = new ArrayList<>(hs);
        
//         return result;
        
//     }
    
//     public static void helper(String s, int removal, HashSet<String> hs) {
//         if (removal==0) {
//            if (getMinRemovals(s)==0) {
//                if (!hs.contains(s)){
//                     hs.add(s);
//                }
//            }
//             return;
//         }
        
//         for (int i=0; i<s.length(); i++) {
//             String left = s.substring(0, i);
//             String right = s.substring(i+1);
//             helper(left+right, removal-1, hs);
//         }
//     }
    
//     public static int getMinRemovals(String s) {
//         Stack<Character> st = new Stack<>();
        
//         for (int i=0; i<s.length(); i++) {
//             Character curChar = s.charAt(i);

            
//             if (curChar == '(') {
//                 st.push(curChar);
//             } else if (curChar == ')') {
//                 if (st.size()==0) {
//                     st.push(curChar);
//                 }
//                 else if(st.peek() == '(') {
//                     st.pop();
//                 } else {
//                     st.push(curChar);
//                 }
//             } 
//         }
        
//         return st.size();
//     }
// }



class Solution {
    List<String> res=new ArrayList<>();
    HashSet<String> visited=new HashSet<>();
    
    //so firstly checking that which of parenthesis is invalid
    //so pushing the ( bracket into stack and and then checking if ) bracket is there and checking that top of stack is (then pop ( bracket from stack and whatever bracket is extra put into hashset and getting size of that stack
    
    public int getMinInvalid(String s){
          Stack<Character> st = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            Character curChar = s.charAt(i);

            
            if (curChar == '(') {
                st.push(curChar);
            } else if (curChar == ')') {
                if (st.size()==0) {
                    st.push(curChar);
                }
                else if(st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(curChar);
                }
            } 
        }
        
        return st.size();
    }
    
    
    
    //so we will be checking if duplicate set is not present of same and set is not containing that 
    //brackets then it is put in set otherwise if it is present is it not again put
    void solve(String s,int minInv,HashSet<String> duplicate){
        if(minInv==0){
            int now=getMinInvalid(s);
            if(now==0){
                if(duplicate.contains(s)==false){
                    duplicate.add(s);
                    res.add(s);
                }
            }
            return;
        }
        //here we will be spliting string into left and right part as we see if any invalid parenthesis is present then ten from where we split the string into two part so valid parenthesis is formed
        //like "()())()" so here we see if we remove 1 bracket ")())() then it is not valid parenthesis" and if we remove 2 bracket "(())()" then it is valid parenthesis
        //now removing 3 bracket "()))()" now it is not valid parentesis then removing 4 breakcet "()()()" so it a valid parenthesisand so on 
        for(int i=0;i<s.length();i++){
            // like ()())() here 4th no bracket ) if removed then it is formed left =()( and right= )()
            //by combining them they are valid bracket
            String left=s.substring(0,i);
            String right=s.substring(i+1);
            
            if(visited.contains(left+right)==false){
                visited.add(left+right);
                solve(left+right,minInv-1,duplicate);
            }
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        int rem=getMinInvalid(s);
        solve(s,rem,new HashSet<>());
        return res;
    }
}