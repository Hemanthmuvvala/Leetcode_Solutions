// Last updated: 11/24/2026, 9:05:32 PM
1class Solution {
2    public int maxLength(int[] nums) {
3        int best = 2, left = 0, product = 1;
4        for (int right = 0; right < nums.length; right++) {
5            int x = nums[right];
6            while (gcd(product, x) > 1)
7                product /= nums[left++];
8            product *= x;
9            best = Math.max(best, right - left + 1);
10        }
11        return best;
12    }
13
14    private int gcd(int a, int b) {
15        return b == 0 ? a : gcd(b, a % b);
16    }
17}