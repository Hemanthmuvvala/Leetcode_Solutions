// Last updated: 7/20/2026, 11:18:12 AM
1class Solution {
2    public List<List<Integer>> permute(int[] nums) {
3        boolean used[]=new boolean[nums.length];
4        List<List<Integer>> result=new ArrayList<>();
5        getPerm(used,new ArrayList<>(),result,nums);
6        return result;
7    }
8    private static void getPerm(boolean [] used,List<Integer> curr,List<List<Integer>> result,int [] nums){
9        if(curr.size()==nums.length){
10            result.add(new ArrayList<>(curr));
11            return;
12        }
13
14        for(int i=0;i<nums.length;i++){
15            
16            if(!used[i]){
17                curr.add(nums[i]);
18                used[i]=true;
19                getPerm(used,curr,result,nums);
20                curr.remove(curr.size()-1);
21                used[i]=false;
22            }
23        }
24    }
25    
26}