// Last updated: 7/12/2026, 11:11:10 PM
class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long[] suffp = new long[n+1];
        suffp[n] = 1;
        for(int i=n-1;i>=0;i--){
            if(suffp[i+1]>1e15)
                suffp[i]= suffp[i+1];
            else suffp[i] =
                suffp[i+1]*nums[i];
        }
        long leftsum = 0;
        for(int i=0;i<n;i++){
            long rightProduct =
                suffp[i+1];
            if(leftsum == rightProduct) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}