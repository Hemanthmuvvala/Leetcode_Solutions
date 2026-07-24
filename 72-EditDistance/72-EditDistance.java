// Last updated: 7/25/2026, 12:07:36 AM
1class Solution {
2    public int minDistance(String word1, String word2) {
3        int n = word1.length();
4        int m = word2.length();
5
6        int dp[][] = new int[n + 1][m + 1];
7
8        for (int i = 1; i <= n; i++) {
9            dp[i][0] = i;
10        }
11
12        for (int j = 1; j <= m; j++) {
13            dp[0][j] = j;
14        }
15        for (int i = 1; i <= n; i++) {
16            for (int j = 1; j <= m; j++) {
17
18                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
19                    dp[i][j] = dp[i - 1][j - 1];
20                } else {
21                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
22                }
23            }
24        }
25        return dp[n][m];
26    }
27}