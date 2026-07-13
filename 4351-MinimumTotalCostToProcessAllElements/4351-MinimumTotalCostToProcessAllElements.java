// Last updated: 7/13/2026, 9:22:00 AM
class Solution {
    public int minimumCost(int[] nums, int k) {
        int n = nums.length;
        long count = 0;
        long mod = 1000000007;

        long val = k; 
        long currentK = k; 

        for (int i = 0; i < n; i++) {
            if (currentK < nums[i]) {
                long need = nums[i] - currentK;
                long ops = (need + val - 1) / val;

                count += ops;
                currentK += ops * val;
            }

            currentK -= nums[i];
        }

        
        long a = count;
        long b = count + 1;
        
        if (a % 2 == 0) {
            a /= 2;
        } else {
            b /= 2;
        }

        return (int) (((a % mod) * (b % mod)) % mod);
    }
}