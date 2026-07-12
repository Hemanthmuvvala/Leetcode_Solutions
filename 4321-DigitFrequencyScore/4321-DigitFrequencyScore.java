// Last updated: 7/12/2026, 11:11:02 PM
class Solution {
    public int digitFrequencyScore(int n) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        while(n>0){
            int rem=n%10;
            map.put(rem,map.getOrDefault(rem,0)+1);
            n=n/10;
        }

        for(int val:map.keySet()){
            sum+=val*map.get(val);
        }

        return sum;
    }
}