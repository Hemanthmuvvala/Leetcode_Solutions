// Last updated: 7/12/2026, 11:13:23 PM
import java.util.*;

class Solution {
    String s;
    int n;
    int K;
    Map<Long, Integer> memo;

    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.n = s.length();
        this.K = k;
        this.memo = new HashMap<>();
        return dfs(0, 0, 0) + 1;
    }

    private int dfs(int i, int curMask, int usedChange) {
        if (i >= n) return 0;
        long key = ((long)i << 32) | ((long)usedChange << 31) | (curMask & 0x7FFFFFFF);
        if (memo.containsKey(key)) return memo.get(key);
        int best = 0;
        int orig = s.charAt(i) - 'a';
        int bitOrig = 1 << orig;
        int maskWithOrig = curMask | bitOrig;
        if (Integer.bitCount(maskWithOrig) > K) best = Math.max(best, 1 + dfs(i + 1, bitOrig, usedChange));
        else best = Math.max(best, dfs(i + 1, maskWithOrig, usedChange));
        if (usedChange == 0) {
            for (int c = 0; c < 26; c++) {
                if (c == orig) continue;
                int bitC = 1 << c;
                int maskWithC = curMask | bitC;
                if (Integer.bitCount(maskWithC) > K) best = Math.max(best, 1 + dfs(i + 1, bitC, 1));
                else best = Math.max(best, dfs(i + 1, maskWithC, 1));
            }
        }
        memo.put(key, best);
        return best;
    }
}