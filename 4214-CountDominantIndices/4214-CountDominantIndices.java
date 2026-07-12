// Last updated: 7/12/2026, 11:11:21 PM
class Solution {
    public int dominantIndices(int[] nums) {
        int n=nums.length;
        int suffix[] =new int[n];
            int count=0;
        int sum=nums[n-1];
        int j=2;
        suffix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){

            sum+=nums[i];

            suffix[i]=sum/j;
            j++;
            
        }
        for(int i=1;i<n;i++){
            if(nums[i-1]>suffix[i]){
                count++;
            }
        }
        
        return count;
    }
}