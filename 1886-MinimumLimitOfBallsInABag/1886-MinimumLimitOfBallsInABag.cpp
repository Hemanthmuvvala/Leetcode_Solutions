// Last updated: 7/13/2026, 12:10:52 AM
class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        int left = 1;
        int right = *max_element(nums.begin(), nums.end());
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            long long total_ops = 0;
            for (int num : nums) {
                total_ops += (num - 1) / mid;
            }
            
            if (total_ops <= maxOperations) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        
        return left;
    }
};
