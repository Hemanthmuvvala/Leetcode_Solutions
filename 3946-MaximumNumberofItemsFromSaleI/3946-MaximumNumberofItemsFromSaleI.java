// Last updated: 11/27/2026, 11:34:13 AM
1class Solution {
2    public int maximumSaleItems(int[][] items, int budget) {
3        int n=items.length;
4
5        int [] bonus=new int[n];
6        int minPrice=Integer.MAX_VALUE;
7
8        for(int i=0;i<n;i++){
9            minPrice=Math.min(minPrice,items[i][1]);
10            for(int j=0;j<n;j++){
11                if(i==j) continue;
12                if(items[j][0]%items[i][0]==0){
13                    bonus[i]++;
14                }
15            }
16        }
17
18        int []dp = new int[budget+1];
19
20        for(int i=0;i<n;i++){
21            int cost=items[i][1];
22            int val=1+bonus[i];
23
24            for(int b=budget;b>=cost;b--){
25                dp[b]=Math.max(dp[b],dp[b-cost]+val);
26            }
27        }
28        int maxItems=0;
29        for(int b=0;b<=budget;b++){
30            int rem=budget-b;
31            int total=dp[b]+(rem/minPrice);
32            maxItems=Math.max(maxItems,total);
33        }
34        return maxItems;
35    }
36}