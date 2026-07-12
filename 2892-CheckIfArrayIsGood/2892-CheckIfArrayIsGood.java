// Last updated: 7/12/2026, 11:13:27 PM
class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
            int n=nums.length-1;
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return false;
            }
        }
        if(nums[nums.length-1] !=n || nums[nums.length-2]!=n){
            return false;
        }

        return true;
    }
}