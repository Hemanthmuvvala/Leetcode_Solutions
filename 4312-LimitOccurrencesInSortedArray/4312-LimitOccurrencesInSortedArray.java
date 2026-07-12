// Last updated: 7/12/2026, 11:10:59 PM
class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
       if(nums.length<=k) return nums;


        int index=0;

        for(int i=0;i<nums.length;i++){
            if(index<k || nums[i]!=nums[index-k]){
                nums[index]=nums[i];
                index++;
            }
        }

        int res[]=new int[index];

        for(int i=0;i<index;i++){
            res[i]=nums[i];
        }
        return res;
    }
}