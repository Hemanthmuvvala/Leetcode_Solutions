// Last updated: 7/13/2026, 12:12:36 AM
class Solution {
    int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][]=new int[n+1][target+1];
        
        for(int row[]:dp) Arrays.fill(row,-1);

        return getRolls(n,k,target,dp);
    }

    public  int getRolls(int n,int k,int target,int dp[][]){

        if(target<0) return 0;

        if(n==0){
            return target==0 ? 1:0;
        }

        if(dp[n][target]!=-1) return dp[n][target];
        int ways=0;
        for(int i=1;i<=k;i++){
            ways=(ways+getRolls(n-1,k,target-i,dp))%MOD;
        }
        dp[n][target]=ways;

        return dp[n][target];
    }
}