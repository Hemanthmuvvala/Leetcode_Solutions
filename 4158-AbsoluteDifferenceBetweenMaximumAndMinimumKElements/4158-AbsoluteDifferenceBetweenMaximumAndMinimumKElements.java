// Last updated: 7/12/2026, 11:11:38 PM
class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int sum=0;
        int sum2=0;

        int total=0;
       // if(nums.length==1) return 0;
        for(int i=nums.length-k;i<nums.length;i++){
            sum=sum+nums[i];
        }
        for(int i=0;i<k;i++){
            sum2=sum2+nums[i];
        }

        total=sum-sum2;

        return Math.abs(total);
    }
}