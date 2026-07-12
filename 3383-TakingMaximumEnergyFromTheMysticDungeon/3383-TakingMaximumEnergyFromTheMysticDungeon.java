// Last updated: 7/12/2026, 11:13:16 PM
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int ans = Integer.MIN_VALUE;
        for (int rem = 0; rem < k; rem++) {
            int sum = 0;
            for (int i = n - 1 - rem; i >= 0; i -= k) {
                sum += energy[i];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}