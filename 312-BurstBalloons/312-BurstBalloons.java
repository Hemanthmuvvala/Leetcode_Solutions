// Last updated: 7/17/2026, 11:33:24 PM
1class Solution {
2    public int maxCoins(int[] nums) {
3        int n=nums.length;
4
5        int dp[][]=new int[n+2][n+2];
6        for(int rows[]:dp){
7            Arrays.fill(rows,-1);
8        }
9        int arr[]=new int[n+2];
10
11        arr[0]=1;
12        arr[n+1]=1;
13        for(int i=0;i<n;i++){
14            arr[i+1]=nums[i];
15        }
16        return getMax(1,n,arr,dp);
17    }
18    public static int getMax(int i,int j,int arr[],int dp[][]){
19        if(i>j) return 0;
20
21        if(dp[i][j]!=-1) return dp[i][j];
22        int max=Integer.MIN_VALUE;
23        for(int index=i;index<=j;index++){
24            int coins=arr[i-1]*arr[index]*arr[j+1];
25            int left=getMax(i,index-1,arr,dp);
26            int right=getMax(index+1,j,arr,dp);
27            max=Math.max(max,coins+right+left);
28        }
29        return dp[i][j]=max;
30    }
31}