// Last updated: 7/12/2026, 11:11:29 PM
class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;

        int pos=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                pos=i;
                break;
            }
        }
        boolean isInc=true;
        boolean isDec=true;

        for(int i=0;i<n;i++){
            if((nums[i]+1)%n!=nums[(i+1)%n]){
                isInc=false;
            }
            if((nums[i]-1+n)%n!=nums[(i+1)%n]){
                isDec=false;
            }
        }
        int ans=Integer.MAX_VALUE;

        if(isInc){
            ans=Math.min(ans,pos);
            ans=Math.min(ans,n-pos+2);
        }
        if(isDec){
            ans=Math.min(ans,pos+2);
            ans=Math.min(ans,n-pos);
        }

        return ans==Integer.MAX_VALUE ?-1: ans;
    }
}