// Last updated: 7/12/2026, 11:11:42 PM
class Solution {
    public long minCost(String s, int[] cost) {
        // int totatlCost=0
        long answer = Long.MAX_VALUE;
        long totalCost = 0;

        for (int c : cost) {
            totalCost += c;
        }
        long freq[] = new long[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            freq[ch - 'a'] += cost[i];
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                long dCost = totalCost - freq[i];
                answer = Math.min(answer, dCost);
            }
        }
        return answer;

    }
}