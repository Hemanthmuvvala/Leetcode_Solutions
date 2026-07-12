// Last updated: 7/12/2026, 11:13:29 PM
class Solution {
    public static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {

        int dp[][] = new int[n+1][n + 1];

        for (int rows[] : dp) {
            Arrays.fill(rows, -1);
        }

        return getWays(1, n, x, dp);
    }

    private static int getWays(int index, int target, int x, int dp[][]) {

        if (target == 0)
            return 1;

        long power =(long) Math.pow(index, x);

        if (power > target)
            return 0;

        if (dp[index][target] != -1)
            return dp[index][target];

        int notTake = getWays(index + 1, target, x, dp);

        int Take = getWays(index + 1,target - (int)power, x, dp);

        return dp[index][target] = (notTake + Take) % MOD;
    }
}