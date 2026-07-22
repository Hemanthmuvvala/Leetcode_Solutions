// Last updated: 7/22/2026, 2:32:31 PM
1class Solution {
2    public int coinChange(int[] coins, int amount) {
3        int n=coins.length;
4        int minCoinsdp[]=new int[amount+1];
5
6       
7        if (amount <= 0) return 0;
8
9        for(int i=1;i<=amount;i++){
10                minCoinsdp[i]=Integer.MAX_VALUE;
11                    for(int coin:coins){
12                        if(coin<=i && minCoinsdp[i-coin]!=Integer.MAX_VALUE){
13                            minCoinsdp[i]=Math.min(minCoinsdp[i],1+minCoinsdp[i-coin]);
14                        }
15                    }
16        }
17
18        if(minCoinsdp[amount]==Integer.MAX_VALUE) return -1;
19
20        return minCoinsdp[amount];
21    }
22}