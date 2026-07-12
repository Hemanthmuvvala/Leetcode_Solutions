// Last updated: 7/12/2026, 11:14:35 PM
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] arr =new int[nums.length];
        int first=0;
        int second=1;
        for(int i=0;i<nums.length;i++){

            if(nums[i]>0){
                    arr[first]=nums[i];
                    first+=2;
            }
            if(nums[i]<0){
                arr[second]=nums[i];
                second=second+2;
            }

        }
        return arr;
    }
}