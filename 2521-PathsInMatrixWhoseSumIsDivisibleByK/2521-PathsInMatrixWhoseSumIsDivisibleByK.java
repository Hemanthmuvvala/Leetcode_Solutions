// Last updated: 7/12/2026, 11:13:52 PM
class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 1_000_000_007;
        int[][][] dp = new int[m][n][k];

        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int r = 0; r < k; r++) {
                    int nextRem = (r + grid[i][j]) % k;
                    if (i > 0) {
                        dp[i][j][nextRem] = (dp[i][j][nextRem] + dp[i - 1][j][r]) % mod;
                    }
                    if (j > 0) {
                        dp[i][j][nextRem] = (dp[i][j][nextRem] + dp[i][j - 1][r]) % mod;
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}