// Last updated: 7/12/2026, 11:14:41 PM
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;

        int ans[] = new int[n];

        int index=0;
        int i=0;
        while(i<n){
            if(nums[i]<pivot){
                ans[index]=nums[i];
                index++;
            }
            i++;
        }
        i=0;
        while(i<n){
            if(nums[i]==pivot){
                ans[index]=nums[i];
                index++;
            }
            i++;
        } 
        i=0;
        while(i<n){
            if(nums[i]>pivot){
                ans[index]=nums[i];
                index++;
            }
            i++;
        } 
        return ans;
    }
}