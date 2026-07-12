// Last updated: 7/12/2026, 11:14:52 PM
class Solution {
    public boolean isSameAfterReversals(int num) {
        int num1=reverse(num);
        int num2=reverse(num1);

        if(num==num2) return true;
        
        return false;
    }
    private static int reverse(int n){

        int sum=0;
        int rem=0;

        while(n>0){
            rem=n%10;
            sum=sum*10+rem;
            n=n/10;
        }

        return sum;
    }
}