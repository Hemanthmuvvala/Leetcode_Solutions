// Last updated: 7/21/2026, 11:21:44 PM
1class Solution {
2    public int minCut(String s) {
3        int n = s.length();
4        int dp[] = new int[n];
5
6        Arrays.fill(dp, -1);
7        boolean pal[][]=new boolean[n][n];
8        for (int i = n - 1; i >= 0; i--) {
9            for (int j = i; j < n; j++) {
10
11                if (s.charAt(i) == s.charAt(j)) {
12                    if (j - i <= 2)
13                        pal[i][j] = true;
14                    else
15                        pal[i][j] = pal[i + 1][j - 1];
16                }
17            }
18        }
19
20        return getMin(0, dp, s,pal) - 1;
21    }
22
23    public static int getMin(int index, int dp[], String s,boolean pal[][]) {
24
25        if (index == s.length())
26            return 0;
27
28        if (dp[index] != -1)
29            return dp[index];
30        int min = Integer.MAX_VALUE;
31        int count = 0;
32        for (int i = index; i < s.length(); i++) {
33
34            if (pal[index][i]) {
35                count = 1 + getMin(i + 1, dp, s,pal);
36            }
37            min = Math.min(min, count);
38        }
39
40        return dp[index] = min;
41    }
42    // public static boolean isPalindrome(int i,int j,String s){
43
44    //    while(i<=j){
45
46    //     if(s.charAt(i)!=s.charAt(j)) return false;
47
48    //     i++;
49    //     j--;
50    //    }
51    //     return true;
52    // }
53}