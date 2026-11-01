// Last updated: 11/1/2026, 9:34:54 PM
1class Solution {
2    public int minMoves(int[] nums) {
3        int lo = Arrays.stream(nums).min().getAsInt(), moves = 0;
4        for (int x : nums) moves += x - lo;
5        return moves;
6    }
7}