// Last updated: 7/12/2026, 11:11:32 PM
class Solution {
    public int minAllOneMultiple(int k) {
        if(k%2==0 || k%5==0)return -1;

        int rem=1%k;
        int len=1;

        while(rem!=0){
            rem=(rem*10+1)%k;
            len++;
        }

        return len;
    }
}