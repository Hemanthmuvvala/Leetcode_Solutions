// Last updated: 7/12/2026, 11:13:06 PM
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int arr[]=new int[2];
        int j=0;

        for(int i=0;i<nums.length;i++){
            
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
        }

        

       

         for(int key:map.keySet()){
            if(map.get(key)==2){
              arr[j]=key;
              j++;
            }
        }

        return arr;
    }
}