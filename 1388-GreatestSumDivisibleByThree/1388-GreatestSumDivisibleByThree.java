// Last updated: 7/13/2026, 12:12:16 AM
class Solution {
    public int maxSumDivThree(int[] nums) {
        
        int max = 0;
        int n = nums.length;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int smin1 = Integer.MAX_VALUE;
        int smin2 = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            max += nums[i];
            int r = nums[i] % 3;
            if(r == 1){
                if(nums[i] < min1){
                    smin1 = min1;
                    min1 = nums[i];
                }else if(nums[i] < smin1){
                    smin1 = nums[i];
                }
            }else if(r == 2){
                if(nums[i] < min2){
                    smin2 = min2;
                    min2 = nums[i];
                }else if(nums[i] < smin2){
                    smin2 = nums[i];
                }
            }
        }

        if(max % 3 == 0) return max;
        if(max % 3 == 1){
            return Math.max(
                (min1 == Integer.MAX_VALUE ? 0 : max - min1),
                (min2 == Integer.MAX_VALUE || smin2 == Integer.MAX_VALUE ? 0 : max - min2 - smin2)
            );
        }else{ 
            return Math.max(
                (min2 == Integer.MAX_VALUE ? 0 : max - min2),
                (min1 == Integer.MAX_VALUE || smin1 == Integer.MAX_VALUE ? 0 : max - min1 - smin1)
            );
        }
    }
}
