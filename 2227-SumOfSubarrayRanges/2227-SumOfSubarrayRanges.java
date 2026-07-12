// Last updated: 7/12/2026, 11:14:55 PM
class Solution {
    public long subArrayRanges(int[] nums) {
       
      int n = nums.length;
      long sum = 0;
      for(int i=0; i<n; i++){
        int j=i;
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        while(j>=0){
        max = Math.max(max, nums[j]);
        min = Math.min(min, nums[j]);
        sum+=max-min;
        j--;
        }
      }
      return sum;
    
    }
}