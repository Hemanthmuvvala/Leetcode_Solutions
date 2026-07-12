// Last updated: 7/13/2026, 12:11:47 AM
class Solution {
    public int maxEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int day=1;
        int ans=0,i=0;
        while(i<n || !pq.isEmpty()){

            while(i<n && events[i][0]<=day){
                pq.offer(events[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll();
                ans++;
            }

            day++;
        }

        return ans;
    }
}