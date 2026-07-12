// Last updated: 7/13/2026, 12:12:11 AM
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n=nums.length;
        if(n%k!=0) return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            pq.offer(nums[i]);
        }

        while(!pq.isEmpty()){
            int val=pq.peek();

            if(map.get(val)==0){
                pq.poll();
                continue;
            }

            for(int i=0;i<k;i++){
                int num=val+i;

                if(!map.containsKey(num) || map.get(num)==0){
                    return false;
                }

                map.put(num,map.get(num)-1);
            }
        }

        return true;
    }
}