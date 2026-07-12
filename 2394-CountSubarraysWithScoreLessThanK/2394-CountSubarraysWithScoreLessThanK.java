// Last updated: 7/12/2026, 11:14:15 PM
class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left=0;
        int n=nums.length;
        long count=0;
        long   totalSum=0;

        for(int right=0;right<n;right++){
            totalSum+=nums[right];
            while(totalSum*(right-left+1)>=k){
                totalSum-=nums[left];
                left++;
            }
            count+=right-left+1;
        }

        return count;
    }
}