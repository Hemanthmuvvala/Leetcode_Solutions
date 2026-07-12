// Last updated: 7/13/2026, 12:11:34 AM
class Solution {
    public boolean hasAllCodes(String s, int k) {

        int need = 1 << k;
        boolean[] seen = new boolean[need];
        int mask = need - 1;

        int window = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            window = ((window << 1) & mask) | (s.charAt(i) - '0');

            if (i >= k - 1 && !seen[window]) {
                seen[window] = true;
                count++;
                if (count == need) return true;
            }
        }
        return false;
    }
}