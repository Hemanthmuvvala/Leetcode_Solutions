// Last updated: 8/10/2026, 12:16:07 AM
1class Solution {
2    private int dfs(int i, int m, int[] piles, Map<Integer, Integer> memo) {
3        int n = piles.length;
4
5        if (i + m * 2 >= n)
6            return piles[i];
7
8        int key = (i << 8) | m;
9
10        if (memo.containsKey(key))
11            return memo.get(key);
12
13        int res = Integer.MAX_VALUE;
14
15        for (int k = 1; k <= m * 2; k++)
16            res = Math.min(res, dfs(i + k, Math.max(m, k), piles, memo));
17
18        int val = piles[i] - res;
19        
20        memo.put(key, val);
21
22        return val;
23    }
24
25    public int stoneGameII(int[] piles) {
26        int n = piles.length;
27
28        for (int i = n - 2; i >= 0; i--)
29            piles[i] += piles[i + 1];
30
31        Map<Integer, Integer> memo = new HashMap<>();
32
33        return dfs(0, 1, piles, memo);
34    }
35}