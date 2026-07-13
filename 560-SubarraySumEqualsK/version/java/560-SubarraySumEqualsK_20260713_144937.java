// Last updated: 7/13/2026, 2:49:37 PM
1class Solution {
2    public int subarraySum(int[] nums, int k) {
3        int n=nums.length;
4
5        HashMap<Integer,Integer> map=new HashMap<>();
6        map.put(0,1);
7        int prefixSum=0;
8        int count=0;
9        for(int i=0;i<n;i++){
10             prefixSum+=nums[i];
11             int target=prefixSum-k;
12             if(map.containsKey(target)){
13                count+=map.get(target);
14             }
15             map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
16        }
17        return count;
18    }
19}