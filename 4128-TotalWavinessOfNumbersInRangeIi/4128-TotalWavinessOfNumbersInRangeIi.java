// Last updated: 7/12/2026, 11:11:50 PM
import java.util.*;

class Solution {

    static class Pair {
        long ways;
        long sum;

        Pair(long ways, long sum) {
            this.ways = ways;
            this.sum = sum;
        }
    }

    char[] digits;
    Pair[][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return countWaviness(num2) - countWaviness(num1 - 1);
    }

    private long countWaviness(long n) {
        if (n < 100) return 0; // Numbers < 3 digits have waviness 0

        digits = String.valueOf(n).toCharArray();
        // State: pos, last2, last1, started, tight
        // last2 and last1: 0-9 for digits, 10 for "none"
        memo = new Pair[digits.length][11][11][2][2];

        return dfs(0, 10, 10, 0, 1).sum;
    }

    private Pair dfs(int pos, int last2, int last1, int started, int tight) {
        if (pos == digits.length) {
            return new Pair(1, 0);
        }

        if (memo[pos][last2][last1][started][tight] != null) {
            return memo[pos][last2][last1][started][tight];
        }

        int limit = (tight == 1) ? digits[pos] - '0' : 9;
        long totalWays = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {
            int nTight = (tight == 1 && d == limit) ? 1 : 0;
            
            if (started == 0) {
                // Not started yet
                Pair nxt = (d == 0) 
                    ? dfs(pos + 1, 10, 10, 0, nTight) 
                    : dfs(pos + 1, 10, d, 1, nTight);
                
                totalWays += nxt.ways;
                totalSum += nxt.sum;
            } else {
                // Already started
                int isWavy = 0;
                if (last2 != 10) { // We have at least 3 digits (last2, last1, d)
                    if ((last1 > last2 && last1 > d) || (last1 < last2 && last1 < d)) {
                        isWavy = 1;
                    }
                }
                
                Pair nxt = dfs(pos + 1, last1, d, 1, nTight);
                
                totalWays += nxt.ways;
                totalSum += nxt.sum + (isWavy * nxt.ways);
            }
        }

        return memo[pos][last2][last1][started][tight] = new Pair(totalWays, totalSum);
    }
}
