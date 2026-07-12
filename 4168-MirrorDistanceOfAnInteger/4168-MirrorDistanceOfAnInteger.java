// Last updated: 7/12/2026, 11:11:36 PM
class Solution {
    public int mirrorDistance(int n) {
        int rem=0;
        long sum=0;
        int temp=n;

        while(n!=0){
            rem=n%10;
            sum=sum*10+rem;
            n=n/10;
        }

        return (int)Math.abs(temp-sum);
    }
}