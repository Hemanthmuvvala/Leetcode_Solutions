// Last updated: 7/12/2026, 11:13:47 PM
class Solution {
    public int alternateDigitSum(int n) {
        int i=0;
        int sum=0,rem=0;
        while(n>0){
            if(i%2==0){
               rem=n%10;
              sum+=rem;
              n=n/10;
              i++;
            }else{
              rem=n%10;
              sum=sum-rem;
              n=n/10;
              i++;
            }
        }
        
        if(i%2==0){
            return -sum;
        }else{
            
        
        return sum;
        }
    }
}