// Last updated: 7/21/2026, 9:37:22 AM
1class Solution {
2    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
3        List<List<Integer>> result = new ArrayList<>();
4        Arrays.sort(candidates); 
5        backtrack(0, target, new ArrayList<>(), candidates, result);
6        return result;
7    }
8
9    private void backtrack(int start, int remainingTarget, List<Integer> curr, int[] nums, List<List<Integer>> result) {
10       
11        if (remainingTarget == 0) {
12            result.add(new ArrayList<>(curr));
13            return;
14        }
15        for (int i = start; i < nums.length; i++) {  
16            if (i > start && nums[i] == nums[i - 1]) {
17                continue;
18            }
19            if (nums[i] > remainingTarget) {
20                break; 
21            }
22            curr.add(nums[i]);
23            backtrack(i + 1, remainingTarget - nums[i], curr, nums, result);
24            curr.remove(curr.size() - 1);
25        }
26    }
27}