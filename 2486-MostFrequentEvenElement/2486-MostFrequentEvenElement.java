// Last updated: 7/12/2026, 11:13:56 PM
class Solution {
    public int mostFrequentEven(int[] nums) {
      HashMap<Integer,Integer> map=new HashMap<>();
      int max=0,real=Integer.MAX_VALUE;
      for(int i=0;i<nums.length;i++){
        if(nums[i]%2==0){
            if(map.containsKey(nums[i])){
                map.put(nums[i],(map.get(nums[i]))+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
      }
      for(int key:map.keySet()){
        if(map.get(key)>max){
            max=map.get(key);
           
        }
      }
       for(int key:map.keySet()){
        if(map.get(key)==max){
           
            
            real= Math.min(real,key);

        }
      }
      if(map.isEmpty()){
        return -1;
      }
      else{
          return real;
      }
     
    }
}