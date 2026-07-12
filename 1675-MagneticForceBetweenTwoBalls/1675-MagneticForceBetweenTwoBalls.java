// Last updated: 7/13/2026, 12:11:06 AM
class Solution {
    public int maxDistance(int[] position, int m) {
        
        int n=position.length;
        Arrays.sort(position);
        int low=1;
        int high=position[n-1]-position[0];
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(isValid(position,m,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return ans;

    }

    private boolean isValid(int [] nums,int balls,int distance){
        int count=1;
        int lastIndex=nums[0];
        for(int i=1;i<nums.length;i++){

            if(nums[i]-lastIndex>=distance){
                    count++;
                    lastIndex=nums[i];
                    if(count==balls){
                        return true;
                    }
            }
        }

        return false;
    }
}