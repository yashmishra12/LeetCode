class Solution {
    public int minInsertions(String s) {
        s = s.replace("))", "]");
        
        int open = 0, score = 0;
        
        for (char c: s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open>0) {
                    
                    open--; //consume in both cases: ) or ]
                    
                    if (c==')') {
                        score += 1; // () needs another ). So, consume () and mark that 1 more needed
                    } else if (c==']') {
                        score += 0; //pura consume. No imbalanced
                    }
                    
                } else { // nothing to consume
                      if (c==')') {
                        score += 2; // ) needs another ( and ) --> ())
                    } else if (c==']') {
                        score += 1; // ] needs ( --> (]
                    }
                }
            }
        }
        
        return (score + open*2);
    }
}