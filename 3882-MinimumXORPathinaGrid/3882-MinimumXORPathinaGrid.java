// Last updated: 10/28/2026, 11:35:38 PM
1class Solution {
2    static final int LIM = 1 << 10;
3    static final int BUCK = LIM >> 5;
4    static final int MASK = (1 << 5) - 1;
5
6    public int minCost(int[][] A) {
7        int m = A.length, n = A[0].length;
8        int[][] dp = new int[n][BUCK];
9        
10        dp[0][A[0][0] >> 5] |= 1 << (A[0][0] & MASK);
11
12        for (int i = 0; i < m; i++) {
13            for (int j = 0; j < n; j++) {
14                if (i == 0 && j == 0) continue;
15
16                int[] prev = new int[BUCK];
17                
18                if (i > 0) for (int k = 0; k < BUCK; k++) prev[k] |= dp[j][k];
19                if (j > 0) for (int k = 0; k < BUCK; k++) prev[k] |= dp[j - 1][k];
20
21                int val = A[i][j];
22                int[] curr = new int[BUCK];
23                
24                for (int k = 0; k < LIM; k++)
25                    if ((prev[k >> 5] & (1 << (k & MASK))) != 0)
26                        curr[(k ^ val) >> 5] |= 1 << ((k ^ val) & MASK);
27
28                dp[j] = curr;
29            }
30        }
31
32        for (int k = 0; k < LIM; k++)
33            if ((dp[n - 1][k >> 5] & (1 << (k & MASK))) != 0) return k;
34
35        return 0;
36    }
37}