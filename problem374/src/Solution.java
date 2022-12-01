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
        long start = 1;
        long end = n;
        while (true) {
            long nextGuess = start + (end - start) / 2;
            if (guess((int) nextGuess) == 0) {
                return (int) nextGuess;
            }
            else if (guess((int) nextGuess + 1) == 0) {
                return (int) nextGuess + 1;
            } else if (guess((int) nextGuess) == -1) {
                end = nextGuess;
            } else {
                start = nextGuess;
            }
        }
    }

    public int guessNumberTern(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }

    public int guessNumberBest(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int nextGuess = (start + end) >>> 1;
            if (guess((int) nextGuess) <= 0) {
                end = nextGuess;
            } else {
                start = nextGuess + 1;
            }
        }
        return start;
    }
}
