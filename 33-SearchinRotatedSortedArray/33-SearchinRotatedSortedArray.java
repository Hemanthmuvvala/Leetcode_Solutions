// Last updated: 7/17/2026, 9:16:33 AM
1class Solution {
2    public int search(int[] nums, int target) {
3        int low = 0, high = nums.length - 1;
4
5        while (low <= high) {
6            int mid = (low + high) / 2;
7
8            if (nums[mid] == target) {
9                return mid;
10            }
11
12            if (nums[low] <= nums[mid]) {
13                if (nums[low] <= target && target < nums[mid]) {
14                    high = mid - 1;
15                } else {
16                    low = mid + 1;
17                }
18            } else {
19                if (nums[mid] < target && target <= nums[high]) {
20                    low = mid + 1;
21                } else {
22                    high = mid - 1;
23                }
24            }
25        }
26
27        return -1;
28    }
29}