// Last updated: 7/12/2026, 11:14:49 PM
class Solution {
    public int minimumCost(int[] cost) {
        int n=cost.length;
        
        Arrays.sort(cost);
        int freeCandy=0;
        int sum=0;
        for(int i=n-1;i>=0;i--){
            
            if(freeCandy==2){
                freeCandy=0;
            }
            else{
            sum+=cost[i];
            freeCandy++;
            }
        }
        
        return sum;
        
    }
}