// Last updated: 7/13/2026, 12:11:14 AM
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int low=0;
        int high=n-1;

        while(low<=high){

            int mid=(low+high)/2;

            if(arr[mid]-(mid+1)<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return low+k;
    }
}