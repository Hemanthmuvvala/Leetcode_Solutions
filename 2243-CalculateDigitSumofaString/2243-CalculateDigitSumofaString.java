// Last updated: 11/16/2026, 6:45:16 PM
1class Solution {
2    public String digitSum(String s, int k) {
3        while (s.length() > k) {
4            StringBuilder next = new StringBuilder();
5            for (int i = 0; i < s.length(); i += k)
6                next.append(s.substring(i, Math.min(i + k, s.length())).chars().map(d -> d - '0').sum());  // the digit sum of one group
7            s = next.toString();
8        }
9        return s;
10    }
11}