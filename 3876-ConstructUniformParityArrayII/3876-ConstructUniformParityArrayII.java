// Last updated: 9/4/2026, 12:29:03 AM
1class Solution {
2    public boolean uniformArray(int[] a) {
3        int mn = Integer.MAX_VALUE;
4        int oddCnt = 0;
5        for (int x : a) {
6            mn = Math.min(mn, x);
7            if (x % 2 == 1) oddCnt++;
8        }
9        // min Element is ODD(remaining even > min) or All Even!
10        return mn % 2 != 0 || oddCnt == 0;
11    }
12}