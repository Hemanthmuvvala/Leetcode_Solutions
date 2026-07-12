// Last updated: 7/12/2026, 11:11:53 PM
class Solution {
    public int finalElement(int[] nums) {
        int n=nums.length;
        return Math.max(nums[0],nums[n-1]);

        
    }
}