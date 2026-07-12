// Last updated: 7/13/2026, 12:12:45 AM
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            pq.add(stone);
        }
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            if(first != second){
                pq.add(first - second);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}