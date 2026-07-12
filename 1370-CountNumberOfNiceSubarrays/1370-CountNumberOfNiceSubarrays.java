// Last updated: 7/13/2026, 12:12:18 AM
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int n=nums.length;

        for(int right=0;right<n;right++){
            if(nums[right]%2!=0){
                nums[right]=1;
            }else{
                nums[right]=0;
            }
        }

        return atmostSub(nums,k)-atmostSub(nums,k-1);

    }
    private static int  atmostSub(int nums[],int k){
        int count=0;
        int sum=0;
        int left=0;
        int n=nums.length;
        for(int right=0;right<n;right++){
            sum+=nums[right];

            while(sum>k){
                sum-=nums[left];
                left++;
            }
            count+=(right-left+1);
        }        
        return count;
    }
}