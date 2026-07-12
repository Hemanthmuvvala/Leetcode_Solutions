// Last updated: 7/13/2026, 12:12:06 AM
class Solution {
    public int minInsertions(String s) {
         int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int prevDiagonal = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (s.charAt(i - 1) == s.charAt(n - j)) {
                    dp[j] = 1 + prevDiagonal;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prevDiagonal = temp;
            }
        }
        return n-dp[n];
    }
}