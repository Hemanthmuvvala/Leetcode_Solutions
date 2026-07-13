// Last updated: 7/13/2026, 12:27:46 PM
1class Solution {
2    boolean isprime(int n) {
3        if (n <= 1) return false;
4        for (int i = 2; i * i <= n; i++) {
5            if (n % i == 0) {
6                return false;
7            }
8        }
9        return true;
10    }
11
12    public boolean completePrime(int num) {
13
14        if (num < 10) {
15            return isprime(num);
16        }
17        String s = String.valueOf(num);
18        StringBuffer prefix = new StringBuffer(s);
19        while (prefix.length() > 0) {
20            int pre = Integer.parseInt(prefix.toString());
21            if (!isprime(pre)) {
22                return false;
23            }
24            prefix.deleteCharAt(prefix.length() - 1);
25        }
26
27       
28        StringBuffer suffix = new StringBuffer(s);
29        while (suffix.length() > 0) {
30            int suf = Integer.parseInt(suffix.toString());
31            if (!isprime(suf)) {
32                return false;
33            }
34            suffix.deleteCharAt(0);
35        }
36
37        return true;
38    }
39}