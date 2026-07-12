// Last updated: 7/12/2026, 11:12:36 PM
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;

        int [] bonus=new int[n];
        int minPrice=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            minPrice=Math.min(minPrice,items[i][1]);
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(items[j][0]%items[i][0]==0){
                    bonus[i]++;
                }
            }
        }

        int []dp = new int[budget+1];

        for(int i=0;i<n;i++){
            int cost=items[i][1];
            int val=1+bonus[i];

            for(int b=budget;b>=cost;b--){
                dp[b]=Math.max(dp[b],dp[b-cost]+val);
            }
        }
        int maxItems=0;
        for(int b=0;b<=budget;b++){
            int rem=budget-b;
            int total=dp[b]+(rem/minPrice);
            maxItems=Math.max(maxItems,total);
        }
        return maxItems;
    }
}