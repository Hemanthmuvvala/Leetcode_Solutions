// Last updated: 7/13/2026, 12:11:31 AM
class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            pq.offer(nums[i]);
        }

        int first=pq.poll()-1;
        int second=pq.poll()-1;

        return first*second;
    }
}