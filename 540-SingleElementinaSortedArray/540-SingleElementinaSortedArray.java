// Last updated: 7/17/2026, 2:10:15 PM
1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3        int start = 1;
4        int n = nums.length;
5        int end = n - 1;
6        int mid = 0;
7        if (n == 1)
8            return nums[0];
9        if (nums[n - 1] != nums[n - 2])
10            return nums[n - 1];
11        if (nums[0] != nums[1])
12            return nums[0];
13
14        while (start <= end) {
15            mid = (start + end) / 2;
16            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
17                return nums[mid];
18
19            if (mid % 2 != 0 && nums[mid] == nums[mid - 1] || mid % 2 == 0 && nums[mid] == nums[mid +1]) {
20                start = mid + 1;
21            } else {
22                end = mid - 1;
23            }
24        }
25        return -1;
26    }
27}