// Last updated: 7/12/2026, 11:12:54 PM
class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int[] temp = nums.clone();
                if (canMakeZero(temp, i, 1)) ans++;
                temp = nums.clone();
                if (canMakeZero(temp, i, -1)) ans++;
            }
        }
        return ans;
    }

    private boolean canMakeZero(int[] arr, int curr, int dir) {
        int n = arr.length;
        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir;
            } else {
                arr[curr]--;
                dir *= -1;
                curr += dir;
            }
        }
        for (int num : arr) {
            if (num != 0) return false;
        }
        return true;
    }
}