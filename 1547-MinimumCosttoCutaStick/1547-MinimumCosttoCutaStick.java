// Last updated: 7/17/2026, 12:07:39 PM
1class Solution {
2
3    public int minCost(int n, int[] cuts) {
4
5        Arrays.sort(cuts);
6
7        int[] newCuts = new int[cuts.length + 2];
8
9        newCuts[0] = 0;
10        newCuts[newCuts.length - 1] = n;
11
12        for(int i = 1; i < newCuts.length - 1; i++){
13            newCuts[i] = cuts[i - 1];
14        }
15        int dp[][]=new int[newCuts.length][newCuts.length];
16
17        for(int rows[]:dp){
18            Arrays.fill(rows,-1);
19        }
20        return getMin(1, cuts.length, newCuts,dp);
21    }
22
23    public int getMin(int i, int j, int[] newCuts,int dp[][]){
24
25        if(i > j)
26            return 0;
27        if(dp[i][j]!=-1)return dp[i][j];
28        int min = Integer.MAX_VALUE;
29
30        for(int ind = i; ind <= j; ind++){
31            int cost = newCuts[j + 1] - newCuts[i - 1];
32            int left = getMin(i, ind - 1, newCuts,dp);
33            int right = getMin(ind + 1, j, newCuts,dp);
34            min = Math.min(min, cost + left + right);
35        }
36
37        return dp[i][j]=min;
38    }
39}