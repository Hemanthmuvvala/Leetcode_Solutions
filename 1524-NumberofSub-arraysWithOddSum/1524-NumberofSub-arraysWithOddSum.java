// Last updated: 11/15/2026, 11:39:23 PM
1class Solution {
2    public int numOfSubarrays(int[] arr) {
3        Arrays.parallelPrefix(arr, Integer::sum);  // arr becomes its own prefix sums, in place
4        long odd = Arrays.stream(arr).map(p -> p & 1).sum();  // odd prefix sums
5        return (int) (odd * (arr.length + 1 - odd) % 1_000_000_007);  // the empty prefix is even
6    }
7}