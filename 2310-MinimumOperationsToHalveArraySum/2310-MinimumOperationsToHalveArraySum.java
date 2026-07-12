// Last updated: 7/12/2026, 11:14:22 PM
class Solution {
    public int halveArray(int[] nums) {
        double totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        double target = totalSum / 2;
        double reduced = 0;
        int operations = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.offer((double) num);
        }
        while (reduced < target) {
            double val = pq.poll();
            double half = val / 2.0;
            reduced += half;
            pq.offer(half);
            operations++;
        }
        return operations;
    }
}