// Last updated: 7/12/2026, 11:14:26 PM
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 1;
        long high = (long) Arrays.stream(time).min().getAsInt() * totalTrips;
        long ans = high;
        int n=time.length;
        
        while(low<=high){
            long mid=(low+high)/2;

            if(getTime(time,totalTrips,mid)){
                ans=mid;
                 high=mid-1;
            
            }else{
                   low=mid+1;
            }
        }

        return ans;
    }

    private static boolean getTime(int [] nums,long trips,long time){
        long totalTime=0;

        for(int c:nums){
            totalTime+=(time/c);
            if(totalTime>=trips) return true;
        }

        return false;
    }
}