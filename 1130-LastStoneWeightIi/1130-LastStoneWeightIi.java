// Last updated: 7/13/2026, 12:12:42 AM
class Solution {
    public int lastStoneWeightII(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int val:nums){
            sum+=val;
        }
        int target=sum/2;

        int dp[][]=new int[n][target+1];

        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        int t=getminWeight(n-1,target,nums,dp);
        return   sum - (2 * t);    
    }

    
    public static int getminWeight(int index,int target,int []nums,int dp[][]){

        if(target==0) return 0;

        if(index==0) return (nums[0] <= target) ? nums[0] : 0;

        if(dp[index][target]!=-1) return dp[index][target];

        int notTake=getminWeight(index-1,target,nums,dp);
        int take=0;
        if(nums[index]<=target){
            take=nums[index]+getminWeight(index-1,target-nums[index],nums,dp);
        }

        return dp[index][target]=Math.max(notTake,take);
    }
}