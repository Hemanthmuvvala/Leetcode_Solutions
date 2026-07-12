// Last updated: 7/12/2026, 11:11:04 PM
class Solution {
    public int sumOfGoodIntegers(int n, int k) {

        int sum=0;

        int s=Math.max(1,n-k);
        int e=n+k;

        for(int x=s;x<=e;x++){
            if((n & x)==0){
                sum+=x;
            }
        }

        return sum;
    }
}