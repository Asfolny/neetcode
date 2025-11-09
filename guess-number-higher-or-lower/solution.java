/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int high) {
        int low = 1;
        int mid = low;

        while (low <= high) {
            // high + low roll optimizations for edges
            if (guess(high) == 0) {
                return high;
            }
            if (guess(low) == 0) {
                return low;
            }

            mid = (low / 2 + high / 2);
            
            switch (guess(mid)) {
                case -1 -> high = mid -1;
                case 1 -> low = mid + 1;
                default -> { return mid; }
            }
        }

        return mid;
    }
}
