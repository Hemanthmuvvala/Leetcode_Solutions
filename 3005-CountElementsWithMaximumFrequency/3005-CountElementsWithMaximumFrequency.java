// Last updated: 7/17/2026, 9:18:42 AM
1import java.util.*;
2
3class Solution {
4    public int maxFrequencyElements(int[] nums) {
5        HashMap<Integer, Integer> map = new HashMap<>();
6
7        
8        for (int i = 0; i < nums.length; i++) {
9            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
10        }
11
12        
13        int maxFreq = Collections.max(map.values());
14
15        
16        int count = 0;
17        for (int freq : map.values()) {
18            if (freq == maxFreq) {
19                count += freq; 
20            }
21        }
22
23        return count;
24    }
25}
26