// Last updated: 7/17/2026, 9:09:19 AM
1import java.util.*;
2
3class Solution {
4
5    public int maxPoints(int[][] points) {
6
7        int n = points.length;
8        if (n <= 2)
9            return n;
10
11        int ans = 1;
12
13        for (int i = 0; i < n; i++) {
14
15            HashMap<String, Integer> map = new HashMap<>();
16            int max = 0;
17
18            for (int j = i + 1; j < n; j++) {
19
20                int dx = points[j][0] - points[i][0];
21                int dy = points[j][1] - points[i][1];
22                if (dx < 0) {
23                    dx = -dx;
24                    dy = -dy;
25                }
26
27                if (dx == 0) {
28                    dy = 1; 
29                }
30
31                if (dy == 0) {
32                    dx = 1; 
33                }
34                int g = gcd(dx, dy);
35
36                dx /= g;
37                dy /= g;
38
39                String key = dx + "," + dy;
40
41                map.put(key, map.getOrDefault(key, 0) + 1);
42
43                max = Math.max(max, map.get(key));
44            }
45
46            ans = Math.max(ans, max + 1);
47        }
48        return ans;
49    }
50
51    private int gcd(int a, int b) {
52        if (b == 0)
53            return Math.abs(a);
54        return gcd(b, a % b);
55    }
56}