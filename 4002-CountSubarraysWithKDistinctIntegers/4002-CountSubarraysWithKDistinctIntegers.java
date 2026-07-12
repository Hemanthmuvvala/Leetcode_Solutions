// Last updated: 7/12/2026, 11:12:14 PM
class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        int left = 0;
        int p = 0;         
        long subArr = 0;   
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int valid = 0;     

        for (int right = 0; right < n; right++) {
            int val = nums[right];
            map.put(val, map.getOrDefault(val, 0) + 1);

            if (map.get(val) == m) {
                valid++;
            }
            while (map.size() > k) {
                int lv = nums[left];

                if (map.get(lv) == m) {
                    valid--;
                }

                map.put(lv, map.get(lv) - 1);
                if (map.get(lv) == 0) {
                    map.remove(lv);
                }

                left++;
                p = 0;
            }
            while (map.size() == k && map.get(nums[left]) > m) {
                int lv = nums[left];
                map.put(lv, map.get(lv) - 1);
                left++;
                p++;
            }
            if (map.size() == k && valid == k) {
                subArr += 1 + p;
            }
        }

        return subArr;
    }
}