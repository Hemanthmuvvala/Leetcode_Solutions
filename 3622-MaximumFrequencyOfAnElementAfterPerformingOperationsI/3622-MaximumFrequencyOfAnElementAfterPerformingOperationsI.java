// Last updated: 7/12/2026, 11:12:44 PM
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        java.util.HashMap<Integer,Integer> cnt = new java.util.HashMap<>();
        java.util.TreeMap<Integer,Integer> line = new java.util.TreeMap<>();
        java.util.TreeSet<Integer> candidates = new java.util.TreeSet<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            int l = num - k;
            int r = num + k + 1;
            line.put(l, line.getOrDefault(l, 0) + 1);
            line.put(r, line.getOrDefault(r, 0) - 1);
            candidates.add(num);
            candidates.add(l);
            candidates.add(r);
        }
        int ans = 1;
        int s = 0;
        for (int x : candidates) {
            if (line.containsKey(x)) s += line.get(x);
            int existing = cnt.getOrDefault(x, 0);
            ans = Math.max(ans, Math.min(s, existing + numOperations));
        }
        return ans;
    }
}