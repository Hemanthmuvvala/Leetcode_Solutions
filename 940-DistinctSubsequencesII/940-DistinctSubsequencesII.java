// Last updated: 7/28/2026, 11:21:29 PM
1import java.util.*;
2
3class Solution {
4
5    public int distinctSubseqII(String S) {
6        long end[] = new long[26], mod = (long) 1e9 + 7;
7        for (char c : S.toCharArray())
8            end[c - 'a'] = Arrays.stream(end).sum() % mod + 1;
9        return (int) (Arrays.stream(end).sum() % mod);
10    }
11
12    
13}