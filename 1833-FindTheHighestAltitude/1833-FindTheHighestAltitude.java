// Last updated: 7/13/2026, 12:10:41 AM
class Solution {
    public int largestAltitude(int[] gain) {
        int [] prefixSum=new int[gain.length+1];
        prefixSum[0]=0;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<gain.length+1;i++){
            prefixSum[i]=prefixSum[i-1]+gain[i-1];
          
        }
        for(int a:prefixSum){
            max=Math.max(a,max);
        }
        return max;
    }
}