// Last updated: 7/12/2026, 11:13:22 PM
import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        
        int maxFreq = Collections.max(map.values());

        
        int count = 0;
        for (int freq : map.values()) {
            if (freq == maxFreq) {
                count += freq; 
            }
        }

        return count;
    }
}
