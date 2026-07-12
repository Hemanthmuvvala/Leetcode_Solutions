// Last updated: 7/13/2026, 12:11:28 AM
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int high = Arrays.stream(bloomDay).max().getAsInt();

        if (bloomDay.length < m * k)
            return -1;
        int low = 1;
        int ans = -1;
        while (low <= high) {

            int mid = (low + high) / 2;

            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }

    public boolean isPossible(int[] bloomDays, int day, int m, int k) {
        int count = 0;
        int bouquets = 0;

        for (int bloom : bloomDays) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return bouquets >= m;
    }

}