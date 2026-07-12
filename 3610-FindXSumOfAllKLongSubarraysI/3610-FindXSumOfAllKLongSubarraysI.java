// Last updated: 7/12/2026, 11:12:57 PM
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Map<Integer,Integer> freq = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]==b[1]? b[0]-a[0] : b[1]-a[1]);
        for (int i=0;i<n;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
            if (i>=k){
                int old = nums[i-k];
                int f = freq.get(old);
                if (f==1) freq.remove(old);
                else freq.put(old,f-1);
            }
            if (i>=k-1){
                pq.clear();
                for (var e: freq.entrySet()) pq.offer(new int[]{e.getKey(),e.getValue()});
                int r=x,s=0;
                while(r>0 && !pq.isEmpty()){
                    int[] t=pq.poll();
                    s+=t[0]*t[1];
                    r--;
                }
                ans[i-k+1]=s;
            }
        }
        return ans;
    }
}