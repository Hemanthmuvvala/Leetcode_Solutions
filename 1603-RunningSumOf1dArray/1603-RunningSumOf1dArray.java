// Last updated: 7/13/2026, 12:11:29 AM
class Solution {
    public int[] runningSum(int[] nums) {
       
        
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
        return nums;
    }
}