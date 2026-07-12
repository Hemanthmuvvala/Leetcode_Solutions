// Last updated: 7/12/2026, 11:11:52 PM
class Solution {
    public long maximumSum(int[] nums, int m, int l, int r) {
        int n=nums.length;
        int end=m;

        long []p=new long[n+1];
        for(int i=0;i<n;i++) p[i+1]=p[i]+nums[i];

        long[][] dp=new long[m+1][n+1];

        long INF=(long)1e18;

        for(long row[]:dp) Arrays.fill(row,-INF);
        Arrays.fill(dp[0],0);

        long ans = -INF;

        for(int j=1;j<=m;j++){

    int[] q = new int[n + 1];
    int head=0,tail=0;

    for(int i = 1;i<=n;i++)
    {
        dp[j][i] = dp[j][i - 1];
        int k = i - l;

        if (k >= 0 && dp[j - 1][k] != -INF) {
            long val = dp[j - 1][k] - p[k];
            while (tail > head && (dp[j - 1][q[tail - 1]] - p[q[tail - 1]]) <= val) {
                tail--;
            }
            q[tail++] = k;
        }

        while(tail > head && q[head] < i-r) head++;

        if(tail>head){
            int best=q[head];
            dp[j][i]=Math.max(dp[j][i],p[i]+dp[j-1][best]-p[best]);
        }
        
    }
            ans=Math.max(ans,dp[j][n]);
    }
    return ans;
}

}