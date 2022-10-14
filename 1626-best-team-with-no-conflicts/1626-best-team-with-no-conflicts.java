class Solution {
    
    class Player {
        public int score;
        public int age;
        
        public Player(int score, int age) {
            this.score = score;
            this.age = age;
        }
    }
    
    public int bestTeamScore(int[] scores, int[] ages) {

        int n = scores.length;
        if(n==1) {return scores[0];}
        Player[] players = new Player[n];
        for(int i = 0; i < n; i++) {
            players[i] = new Player(scores[i], ages[i]);
        }
        
        Arrays.sort(players, (a,b) -> a.age == b.age ? a.score - b.score : a.age - b.age);
        
        int[] dp = new int[n];
        dp[0] = players[0].score;
        int max = 0;
        for(int i = 1; i < n; i++) {
            dp[i] = players[i].score;
            for(int j = 0; j < i; j++) {
                if(players[j].age <= players[i].age && players[j].score <= players[i].score) {
                    dp[i] = Math.max(dp[j] + players[i].score, dp[i]);
                }
            }
            
            max = Math.max(dp[i], max);
        }
        return max;
    }
}