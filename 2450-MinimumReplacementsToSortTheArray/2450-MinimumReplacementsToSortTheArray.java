// Last updated: 7/12/2026, 11:13:59 PM
class Solution {
    public long minimumReplacement(int[] nums) {
        long operations =0;
        int n=nums.length;
        int prev=nums[n-1];
                 for(int i=n-2;i>=0;i--) {

                    if(nums[i]>prev){
                      long parts=(nums[i]+prev-1)/prev;
                            operations+=parts-1;
                           prev= nums[i]/(int)parts;
                    }
                    else{
                        prev=nums[i];
                    }
                 }  
                 return operations;
    }
}