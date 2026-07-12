// Last updated: 7/12/2026, 11:13:48 PM
class Solution {
    public long maxKelements(int[] nums, int k) {
        int n=nums.length;
        long sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int val:nums){
            pq.offer(val);
        }
        while(k>0){
            int remVal=pq.poll();
            int val=(int)Math.ceil(remVal/3.0);
            pq.offer(val);
              sum+=remVal;
            k--;
        }
        return sum;
    }
}