// Last updated: 7/12/2026, 11:14:05 PM
class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int val:nums){
            pq.offer(val);
        }
            int count=0;
            int prev=0;
        while(!pq.isEmpty()){
            int minEle=pq.poll();


            if(minEle>0 && minEle!=prev){
                count++;
                prev=minEle;
            }
        }

        return count;
    }
}