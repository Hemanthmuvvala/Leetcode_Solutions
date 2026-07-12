// Last updated: 7/12/2026, 11:11:41 PM
class Solution {
    public int minLength(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> seen=new HashMap<>();
        int left=0;
        int min=Integer.MAX_VALUE;
        int sum=0;

        for(int right=0;right<n;right++){
            int val=nums[right];
            seen.put(val,seen.getOrDefault(val,0)+1);

            if(seen.get(val)==1){
                sum+=val;
            }

            while(sum>=k){
                min=Math.min(min,right-left+1);
                int remove=nums[left];
                seen.put(remove,seen.get(remove)-1);
                if(seen.get(remove)==0){
                    sum-=remove;
                }
                left++;
            }
        }

        return min==Integer.MAX_VALUE ? -1:min;
    }
}