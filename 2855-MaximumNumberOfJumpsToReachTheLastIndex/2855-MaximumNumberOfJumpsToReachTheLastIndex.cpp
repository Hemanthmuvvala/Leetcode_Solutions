// Last updated: 7/12/2026, 11:13:44 PM
class Solution {
public:
    int maximumJumps(std::vector<int>& nums, int target) {
        int n = nums.size();
        std::vector<int> dp(n, -1);
        
        dp[0] = 0; 
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != -1 && std::abs(nums[i] - nums[j]) <= target) {
                    dp[i] = std::max(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[n - 1];
    }
};
