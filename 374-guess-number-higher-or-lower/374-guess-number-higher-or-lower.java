/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        
        while(left<right){
            int mid = (left) + (int)(right-left)/2;
            int location = guess(mid);
            if(location==0){
                return mid;
            }
            else if(guess(left)==0) {
                return left;
            }
            else if(guess(right)==0){
                return right;
            }
            if (location==-1){
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        
        return 1;
        
    }
}