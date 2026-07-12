// Last updated: 7/12/2026, 11:13:12 PM
import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Long, Long> map = new HashMap<>();
        for (int p : power) map.put((long)p, map.getOrDefault((long)p, 0L) + 1);
        List<Long> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int n = keys.size();
        long[] dp = new long[n];
        dp[0] = keys.get(0) * map.get(keys.get(0));
        for (int i = 1; i < n; i++) {
            long cur = keys.get(i) * map.get(keys.get(i));
            int j = i - 1;
            while (j >= 0 && keys.get(j) >= keys.get(i) - 2) j--;
            long take = cur + (j >= 0 ? dp[j] : 0);
            long notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n - 1];
    }
}