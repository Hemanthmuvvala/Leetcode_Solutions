// Last updated: 7/13/2026, 12:12:27 AM
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
           
             map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Set<Integer>set=new HashSet<>();
        for(int count:map.values()){
            set.add(count);
        }

        int a=set.size();
        int b= map.size();
        
        if(a==b){
            return true;
        }
        return false;
    }
}