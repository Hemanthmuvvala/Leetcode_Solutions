// Last updated: 7/20/2026, 1:49:27 PM
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<List<Integer>> res=new ArrayList<>();
4        getCombo(0,candidates,target,new ArrayList<>(),res);
5
6        return res;
7    }
8    private static void getCombo(int index,int [] nums,int target,List<Integer> curr,List<List<Integer>>res){
9
10            if(index>=nums.length){
11                if(target==0){
12                    res.add(new ArrayList<>(curr));
13                }
14                return;
15            }
16    // beacause of repetiotion elements is allowed if condition is written.
17            if(nums[index]<=target){
18            curr.add(nums[index]);           
19            getCombo(index,nums,target-nums[index],curr,res);
20            curr.remove(curr.size()-1);
21            }
22        // used to add the next element;
23            getCombo(index+1,nums,target,curr,res);
24
25     }
26}