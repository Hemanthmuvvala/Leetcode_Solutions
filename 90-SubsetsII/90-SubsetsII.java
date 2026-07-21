// Last updated: 7/21/2026, 9:33:21 AM
1class Solution {
2    public List<List<Integer>> subsetsWithDup(int[] nums) {
3        List<List<Integer>> result =new ArrayList<>();
4        Arrays.sort(nums);
5         getSubsets(0,nums,new ArrayList<>(),result);
6         return result;
7    }
8
9    private static void getSubsets(int index,int [] nums,List<Integer> current,List<List<Integer>> result){
10        if(index==nums.length){
11            result.add(new ArrayList<>(current));
12            return ;
13        }
14
15        current.add(nums[index]);
16        getSubsets(index+1,nums,current,result);
17        current.remove(current.size()-1);
18         while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
19            index++;
20        }
21         getSubsets(index+1,nums,current,result);
22
23    }
24}