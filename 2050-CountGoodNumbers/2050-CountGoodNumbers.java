// Last updated: 7/12/2026, 11:15:09 PM
class Solution {
      static final long MOD=1_000_000_007;
    public int countGoodNumbers(long n) {
        long evenNum=(n+1)/2;
        long oddNum=n/2;

        long evePow=pow(5,evenNum);
        long oddPow=pow(4,oddNum);

        return (int)((evePow*oddPow)%MOD);
    }

    private static long pow(int x,long n){
        if(n==0) return 1;

        long half=pow(x,n/2);

        half=(half*half)%MOD;

        if(n%2==1)
            half=(x*half)%MOD;
        
        return half;

    }
}