// Last updated: 7/12/2026, 11:12:33 PM
class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] cumPrev = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            cumPrev[i] = cumPrev[i - 1] + (long) skill[i - 1] * mana[0];
        }
        long sPrev = 0;
        for (int j = 1; j < m; j++) {
            long[] cumCur = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                cumCur[i] = cumCur[i - 1] + (long) skill[i - 1] * mana[j];
            }
            long delta = Long.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                long val = cumPrev[i] - cumCur[i - 1];
                if (val > delta) delta = val;
            }
            if (delta < 0) delta = 0;
            sPrev += delta;
            cumPrev = cumCur;
        }
        return sPrev + cumPrev[n];
    }
}