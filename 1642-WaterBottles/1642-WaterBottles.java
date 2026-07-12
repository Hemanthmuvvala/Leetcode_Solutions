// Last updated: 7/13/2026, 12:11:16 AM
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum=numBottles;
    
        while(numBottles>=numExchange){
        int rem=numBottles/numExchange;
            int r=numBottles%numExchange;
            if(rem>0){
                sum=sum+rem;
            }
            
       numBottles=rem+r;
        }
        return sum;
    }
}