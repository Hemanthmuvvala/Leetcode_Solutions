// Last updated: 7/12/2026, 11:13:35 PM
class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;

        int dp[]=new int[n];
        
        Arrays.fill(dp,-2);
        return maxJumps(0,nums,dp,target);
    }
    private static int maxJumps(int index,int nums[],int dp[],int target){
        
        if(index==nums.length-1) return 0;

        if(dp[index]!=-2) return dp[index];
        int ans=-1;
        for(int i=index+1;i<nums.length;i++){
            int val=maxJumps(i,nums,dp,target);

            if(Math.abs(nums[i]-nums[index])<=target){
                if(val!=-1)
                    ans=Math.max(ans,val+1);
            }
        }
        return dp[index]=ans;
    }
}