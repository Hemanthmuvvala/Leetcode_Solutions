// Last updated: 7/12/2026, 11:13:55 PM
class Solution {
    public int minGroups(int[][] intervals) {
        
        int arrival[]=new int[intervals.length];
        int departure[]=new int[intervals.length];
        
        int n=arrival.length;
        int m=departure.length;
        for(int i=0;i<intervals.length;i++){
            arrival[i]=intervals[i][0];
            departure[i]=intervals[i][1];
        }
        int count=0;
        int maxGroups=Integer.MIN_VALUE;
        int i=0;
        int j=0;
        Arrays.sort(arrival);
        Arrays.sort(departure);
        while(i<n && j<m){
            if(arrival[i]<=departure[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
           maxGroups=Math.max(count,maxGroups);
        }
        return maxGroups;
    }
}