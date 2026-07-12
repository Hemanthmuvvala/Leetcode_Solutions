// Last updated: 7/12/2026, 11:11:19 PM
class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n=nums.length;
        int right=0;

        for(int i=1;i<n;i++){

            if(nums[i]>nums[i-1]){
                right++;
            }else{
                right=0;
            }
        }

        return n-(right+1);
    }
}