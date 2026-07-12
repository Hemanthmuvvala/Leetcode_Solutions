// Last updated: 7/12/2026, 11:15:26 PM
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count=0;
        for(int i=0;i<costs.length;i++){
            if(costs[i]<=coins){
                coins=coins-costs[i];
                count++;
            }
            if(coins==0) break;
        }

        return count;
    }
}