// Last updated: 7/12/2026, 11:13:41 PM
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
      
        int[] freq = new int[value];
        for (int n : nums) {
            int mod = ((n % value) + value) % value;
            freq[mod]++;
        }
        int mex = 0;
        while (true) {
            int mod = mex % value;
            if (freq[mod] > 0) {
                freq[mod]--;
                mex++;
            } else {
                return mex;
            }
        }
    }
}
