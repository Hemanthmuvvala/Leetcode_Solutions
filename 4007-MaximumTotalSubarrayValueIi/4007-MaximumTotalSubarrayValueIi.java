// Last updated: 7/12/2026, 11:12:09 PM
import java.util.PriorityQueue;

public class Solution {
    
   
    static class Subarray implements Comparable<Subarray> {
        long val;
        int l;
        int r;

        Subarray(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Subarray other) {
            return Long.compare(other.val, this.val);
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return 0;

       
        int[] logTable = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }

    
        int maxLen = logTable[n] + 1;
        int[][] maxSt = new int[n][maxLen];
        int[][] minSt = new int[n][maxLen];

        for (int i = 0; i < n; i++) {
            maxSt[i][0] = nums[i];
            minSt[i][0] = nums[i];
        }

        for (int j = 1; j < maxLen; j++) {
            for (int i = 0; i <= n - (1 << j); i++) {
                maxSt[i][j] = Math.max(maxSt[i][j - 1], maxSt[i + (1 << (j - 1))][j - 1]);
                minSt[i][j] = Math.min(minSt[i][j - 1], minSt[i + (1 << (j - 1))][j - 1]);
            }
        }

     
        PriorityQueue<Subarray> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long val = getVal(i, n - 1, maxSt, minSt, logTable);
            maxHeap.add(new Subarray(val, i, n - 1));
        }

        // 4. Extract the top K values
        long totalSum = 0;
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            Subarray curr = maxHeap.poll();
            totalSum += curr.val;

            // If we can shrink the right boundary further, push the next candidate
            if (curr.r > curr.l) {
                long nextVal = getVal(curr.l, curr.r - 1, maxSt, minSt, logTable);
                maxHeap.add(new Subarray(nextVal, curr.l, curr.r - 1));
            }
        }

        return totalSum;
    }

  
    private long getVal(int L, int R, int[][] maxSt, int[][] minSt, int[] logTable) {
        int length = R - L + 1;
        int j = logTable[length];
        int mx = Math.max(maxSt[L][j], maxSt[R - (1 << j) + 1][j]);
        int mn = Math.min(minSt[L][j], minSt[R - (1 << j) + 1][j]);
        return (long) mx - mn;
    }
}