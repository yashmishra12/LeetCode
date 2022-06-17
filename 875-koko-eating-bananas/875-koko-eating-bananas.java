class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1, right = 1; 
        for(int pile: piles) {
            //max speed = max pile. Jaldi khake faida nahi hai because koko will wait till the remaining time
            right = Math.max(right, pile); 
        }
        
        while(left < right) {
            int mid = (left+right)/2;
            int hourSpent = 0;
            
            for(int pile: piles) { 
                hourSpent += Math.ceil((double) pile/mid);
                if(hourSpent > h) {break;}
            }
            
            if(hourSpent <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right; 
 
        }     
    }