// Last updated: 7/12/2026, 11:12:42 PM
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            index = (i + nums[i]) % n;
            if (index < 0)
                index += n;
            res[i] = nums[index];
        }

        return res;
    }
}