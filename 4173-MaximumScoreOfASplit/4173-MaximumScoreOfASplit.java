// Last updated: 7/12/2026, 11:11:34 PM
class Solution {
    public long maximumScore(int[] nums) {
        int n=nums.length;

        long[] prefix=new long[n];
        prefix[0]=nums[0];

        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }

        int suffixMin[]=new int [n];
        suffixMin[n-1]=nums[n-1];

        for(int i=n-2;i>=0;i--){
            suffixMin[i]=Math.min(nums[i],suffixMin[i+1]);
        }

        long mscore=Long.MIN_VALUE;

        for(int i=0;i<n-1;i++){
            long score=prefix[i]-suffixMin[i+1];
            //mscore=Math.max(mscore,score);
            if(score>mscore) mscore=score;
        }

        return  mscore;
    }
}