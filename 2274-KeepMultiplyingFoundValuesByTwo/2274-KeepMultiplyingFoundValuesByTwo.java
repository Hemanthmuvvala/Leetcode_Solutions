// Last updated: 7/12/2026, 11:14:34 PM
class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int val=original;

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        while(map.containsKey(original)){
            val=original*2;
            original=val;
        }

        return val;
    }
}