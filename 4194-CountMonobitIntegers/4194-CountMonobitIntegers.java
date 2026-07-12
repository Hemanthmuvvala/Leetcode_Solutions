// Last updated: 7/12/2026, 11:11:22 PM
class Solution {
    public int countMonobit(int n) {
        long l=(long)n+1;

        long p=1;
        int c=0;

        while(p <= l){
            c++;
            p <<= 1;
        }

        return c;
    }
}