// Last updated: 7/12/2026, 11:15:08 PM
class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n=piles.length;
        int sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            pq.offer(piles[i]);
        }

        while(k>0){
            int removePile=pq.poll();
            int val=(removePile/2);
            pq.offer(removePile-val);
            k--;
        }
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }
}