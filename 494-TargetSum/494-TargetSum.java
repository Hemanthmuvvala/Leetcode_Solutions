// Last updated: 7/25/2026, 12:08:21 AM
1class Solution {
2    int ways = 0;
3    public int findTargetSumWays(int[] nums, int target) {
4        dfs(nums,0,0,target);
5        return ways;
6    }
7    void dfs(int []arr,int idx,int sum,int tar){
8        if(idx==arr.length){
9            if(sum==tar){
10                ways++;
11            }
12            return;
13        }
14        dfs(arr,idx+1,sum+arr[idx],tar);
15        dfs(arr,idx+1,sum-arr[idx],tar);
16    }
17}