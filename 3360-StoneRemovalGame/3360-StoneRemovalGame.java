// Last updated: 11/26/2026, 11:52:48 PM
1class Solution {
2    public boolean canAliceWin(int n) {
3        int missing = 55 - n; 
4        long unplayed = Math.round(Math.sqrt(2 * missing));
5        return unplayed % 2 == 1;
6    }
7}