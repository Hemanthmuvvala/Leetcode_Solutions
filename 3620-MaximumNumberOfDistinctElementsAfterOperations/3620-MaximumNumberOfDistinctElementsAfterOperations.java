// Last updated: 7/12/2026, 11:12:46 PM
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int distinct = 0;
        long occupied = Long.MIN_VALUE; 
        
        for (int x : nums) {
            long low  = (long)x - k;
            long high = (long)x + k;
           
            long cur = Math.max(occupied + 1, low);
            if (cur <= high) {
                distinct++;
                occupied = cur;
            }
            
        }
        return distinct;
    }
}
