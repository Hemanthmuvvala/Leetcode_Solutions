// Last updated: 7/13/2026, 12:12:13 AM
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int high=Arrays.stream(nums).max().getAsInt();

        int low=1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;

            if(getDivisor(nums,mid,threshold)){
                ans=mid;
                high=mid-1;
            }else{
                 low=mid+1;
               
            }
        }

        return ans;
    }

    private static boolean getDivisor(int nums[],int div,int threshold){

        int sum=0;
        for(int num:nums){
            sum+=(int)Math.ceil((double)num/div);
        }
        
        return sum<=threshold;
    }
}