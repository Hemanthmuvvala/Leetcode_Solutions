// Last updated: 11/26/2026, 11:50:00 PM
1class Solution {
2    public boolean canAliceWin(int n) {
3        int missing = 55 - n;  // stones short of playing all ten moves
4        long unplayed = Math.round(Math.sqrt(2 * missing));  // smallest j with 1 + 2 + ... + j >= missing
5        return unplayed % 2 == 1;  // 10 - unplayed moves were played: odd means Alice moved last
6    }
7}