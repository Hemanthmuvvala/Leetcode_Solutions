// Last updated: 7/12/2026, 11:12:39 PM
class Solution {
    public int smallestNumber(int n) {
          int k = Integer.SIZE - Integer.numberOfLeadingZeros(n);
        int x = (1 << k) - 1;
        if (x >= n) return x;
        return (1 << (k+1)) - 1;
    }
}