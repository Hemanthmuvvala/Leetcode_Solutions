// Last updated: 7/14/2026, 8:58:40 AM
1class Solution {
2public:
3    int findMaxLength(vector<int>& nums) {
4        unordered_map<int, int> mpp;   // {prefix_sum, first_index}
5
6        int sum = 0;
7        int max_len = 0;
8
9        mpp[0] = -1;
10
11        for (int i = 0; i < nums.size(); i++) {
12            sum += (nums[i] == 0) ? -1 : 1;
13
14            if (mpp.find(sum) != mpp.end())
15                max_len = max(max_len, i - mpp[sum]);
16            else
17                mpp[sum] = i;
18        }
19
20        return max_len;
21    }
22};