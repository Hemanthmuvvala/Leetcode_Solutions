// Last updated: 7/15/2026, 12:11:15 PM
1class Solution {
2    public int maxSubarraySumCircular(int[] nums) {
3
4        int totalSum = 0;
5        for (int num : nums) {
6            totalSum += num;
7        }
8        int currMax = nums[0];
9        int maxSum = nums[0];
10
11        for (int i = 1; i < nums.length; i++) {
12            currMax = Math.max(nums[i], currMax + nums[i]);
13            maxSum = Math.max(maxSum, currMax);
14        }
15        int currMin = nums[0];
16        int minSum = nums[0];
17
18        for (int i = 1; i < nums.length; i++) {
19            currMin = Math.min(nums[i], currMin + nums[i]);
20            minSum = Math.min(minSum, currMin);
21        }
22        if (maxSum < 0) {
23            return maxSum;
24        }
25
26        return Math.max(maxSum, totalSum - minSum);
27    }
28}