// Last updated: 7/13/2026, 12:12:25 AM
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int totalCandies=Arrays.stream(candies).max().getAsInt();

      
        int low=1;
        int high=totalCandies;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;

            long maxChildren=getMaxCandies(candies,mid);

            if(maxChildren>=k){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return ans;
    }

    private static long getMaxCandies(int [] candies,long mid){
        long totalChildren=0;

        for(int c:candies){
            totalChildren+=(int)Math.floor((double)c/mid);
        }

        return totalChildren;
    }
}