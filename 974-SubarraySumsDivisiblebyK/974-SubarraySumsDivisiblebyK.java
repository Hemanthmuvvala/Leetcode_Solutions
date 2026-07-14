// Last updated: 7/14/2026, 11:21:26 AM
1class Solution {
2    public int subarraysDivByK(int[] nums, int k) {
3        HashMap<Integer, Integer> map = new HashMap<>();
4        map.put(0, 1);
5
6        int prefixSum = 0;
7        int count = 0;
8
9        for (int num : nums) {
10            prefixSum += num;
11
12            int rem = prefixSum % k;
13
14            if (rem < 0) {
15                rem += k;
16            }
17
18            if (map.containsKey(rem)) {
19                count += map.get(rem);
20            }
21
22            map.put(rem, map.getOrDefault(rem, 0) + 1);
23        }
24
25        return count;
26    }
27}
28