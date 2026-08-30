// Last updated: 8/30/2026, 9:35:59 PM
1class Solution {
2    public int findContentChildren(int[] g, int[] s) {
3        int n = g.length;
4        int m = s.length;
5
6        Arrays.sort(g);
7        Arrays.sort(s);
8
9        int count = 0;
10
11        int i = 0, j = 0;
12        
13        while(i < n &&  j < m) {
14            if(g[i] <= s[j]) {
15                count++;
16                i++;
17                j++;
18            } else {
19                j++;
20            }
21        }
22
23        return count;
24    }
25} 