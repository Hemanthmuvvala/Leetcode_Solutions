// Last updated: 7/12/2026, 11:13:25 PM
class Solution {
    public int[] numberGame(int[] nums) {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int ans[]=new int[n];
        for(int num:nums){
            pq.offer(num);
        }

        int index = 0;

        while (!pq.isEmpty()) {
            int a = pq.poll(); 
            int b = pq.poll();

            ans[index++] = b;
            ans[index++] = a;
        }

        return ans;
    }
}
