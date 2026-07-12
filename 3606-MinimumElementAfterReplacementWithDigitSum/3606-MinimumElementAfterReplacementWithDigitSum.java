// Last updated: 7/12/2026, 11:12:58 PM
class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            int sum=0;
            while(val>0){
                int rem=val%10;
                sum=sum+rem;
                val=val/10;
            }
           min=Math.min(min,sum);
        }
        
       return min;
    }
}