// Last updated: 7/12/2026, 11:13:38 PM
class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n=gifts.length;
        long sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            pq.offer(gifts[i]);
        }

        while(k>0){
            long val=pq.poll();
            int sqrval=(int)Math.sqrt(val);
            pq.add(sqrval);
            k--;
        }
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }

        return sum;
    }
}