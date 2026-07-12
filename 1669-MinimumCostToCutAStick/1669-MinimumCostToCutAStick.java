// Last updated: 7/13/2026, 12:11:08 AM
class Solution {
       public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] tmp = new int[cuts.length + 2];
        for (int i = 1; i < tmp.length - 1; i++)
            tmp[i] = cuts[i - 1];
        tmp[tmp.length - 1] = n;
        cuts = tmp;
        int[][] memo = new int[cuts.length][cuts.length];
        return helper(0, cuts.length - 1, cuts, memo);
    }
    
    
    private int helper(int start, int end, int[] cuts, int[][] memo){
        if (end - start <= 1) return 0;
        if (memo[start][end] > 0) return memo[start][end];
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++){
            int cand = helper(start, i, cuts, memo) + helper(i,end, cuts, memo);
            min = Math.min(min, cand);
        }
        int ans = min + cuts[end] - cuts[start];
        memo[start][end] = ans;
        return ans;
    }
}