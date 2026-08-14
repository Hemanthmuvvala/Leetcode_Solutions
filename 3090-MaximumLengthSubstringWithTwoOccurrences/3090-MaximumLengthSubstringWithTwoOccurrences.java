// Last updated: 8/15/2026, 12:20:36 AM
1class Solution {
2    public int maximumLengthSubstring(String s) {
3        int res = 0;
4        int[] fq = new int[26];
5
6        for (int l = 0, r = 0; r < s.length(); r++) {
7            fq[(s.charAt(r) & 31) - 1]++;
8
9            while (fq[(s.charAt(r) & 31) - 1] > 2)
10                fq[(s.charAt(l++) & 31) - 1]--;
11
12            res = Math.max(res, r - l + 1);
13        }
14
15        return res;
16    }
17}