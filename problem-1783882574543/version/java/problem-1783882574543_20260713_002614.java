// Last updated: 7/13/2026, 12:26:14 AM
1class Solution {
2    public int minimumCost(int[] nums, int k) {
3        int n = nums.length;
4        long count = 0;
5        long mod = 1000000007;
6
7        long val = k; 
8        long currentK = k; 
9
10        for (int i = 0; i < n; i++) {
11            if (currentK < nums[i]) {
12                long need = nums[i] - currentK;
13                long ops = (need + val - 1) / val;
14
15                count += ops;
16                currentK += ops * val;
17            }
18
19            currentK -= nums[i];
20        }
21
22        
23        long a = count;
24        long b = count + 1;
25        
26        if (a % 2 == 0) {
27            a /= 2;
28        } else {
29            b /= 2;
30        }
31
32        return (int) (((a % mod) * (b % mod)) % mod);
33    }
34}