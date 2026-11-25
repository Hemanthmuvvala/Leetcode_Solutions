// Last updated: 11/25/2026, 11:42:12 AM
1class Solution {
2    public int smallestUniqueSubarray(int[] nums) {
3        int n = nums.length;
4        List<int[]> names = new ArrayList<>();  // names.get(k)[i] is equal for equal windows of length 2^k starting at i
5        names.add(nums);
6        for (int half = 1; 2 * half <= n; half *= 2) {  // blocks of 2, 4, 8, ... while they fit
7            long[] pairs = pairs(names.get(names.size() - 1), half);
8            long[] ids = Arrays.stream(pairs).sorted().distinct().toArray();  // a pair's number: its place among the different pairs
9            names.add(Arrays.stream(pairs).mapToInt(pair -> Arrays.binarySearch(ids, pair)).toArray());
10        }
11
12        int lo = 1, hi = n;  // the first length that works is in lo..hi
13        while (lo < hi) {
14            int mid = (lo + hi) / 2;
15            if (found(names, mid)) hi = mid;
16            else lo = mid + 1;
17        }
18        return lo;
19    }
20
21    private boolean found(List<int[]> names, int length) {  // is some window of this length unique?
22        int k = 31 - Integer.numberOfLeadingZeros(length);  // its first 2^k elements and its last 2^k cover it
23        long[] pairs = pairs(names.get(k), length - (1 << k));
24        Arrays.sort(pairs);  // equal pairs are neighbors now
25        for (int i = 0; i < pairs.length; i++)
26            if ((i == 0 || pairs[i - 1] != pairs[i]) && (i + 1 == pairs.length || pairs[i] != pairs[i + 1]))
27                return true;
28        return false;
29    }
30
31    private long[] pairs(int[] block, int shift) {  // every (block[i], block[i + shift]) as one long
32        long[] pairs = new long[block.length - shift];
33        for (int i = shift; i < block.length; i++)
34            pairs[i - shift] = (long) block[i - shift] << 32 | block[i];
35        return pairs;
36    }
37}