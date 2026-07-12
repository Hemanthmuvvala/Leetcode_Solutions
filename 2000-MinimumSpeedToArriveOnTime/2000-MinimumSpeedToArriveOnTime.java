// Last updated: 7/12/2026, 11:15:19 PM
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = 10000000;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (getSpeed(dist, mid, hour)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static boolean getSpeed(int[] nums, int speed, double hours) {
        double sum = 0.0;

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                sum += (double) nums[i] / speed;
            } else {
                sum += Math.ceil((double) nums[i] / speed);
            }
            if (sum > hours)
                return false;
        }
        return true;
    }
}