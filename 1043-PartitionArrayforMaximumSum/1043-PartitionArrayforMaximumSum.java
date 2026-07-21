// Last updated: 7/21/2026, 11:57:18 PM
1class Solution {
2    public int maxSumAfterPartitioning(int[] arr, int k) {
3        int n=arr.length;
4
5        int dp[]=new int[n];
6        Arrays.fill(dp,-1);
7
8        return getMax(0,arr,dp,k);
9    }
10
11    public static int getMax(int index,int arr[],int dp[],int k){
12
13        if(index==arr.length) return 0;
14
15        if(dp[index]!=-1) return dp[index];
16        int maxNum=0,maxSum=0;
17        int totalSum=0;
18        int length=0;
19        for(int i=index;i<Math.min(arr.length,index+k);i++){
20            length++;
21            maxNum=Math.max(maxNum,arr[i]);
22            totalSum=length*maxNum+getMax(i+1,arr,dp,k);
23            maxSum=Math.max(totalSum,maxSum);
24        }
25        return dp[index]=maxSum;
26    }
27}