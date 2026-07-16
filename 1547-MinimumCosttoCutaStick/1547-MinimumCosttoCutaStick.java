// Last updated: 7/16/2026, 9:18:46 AM
1class Solution {
2    public int peakIndexInMountainArray(int[] arr) {
3        int low=0,high=arr.length-1;
4
5        while(low<high){
6            int mid=low+(high-low)/2;
7
8            if(arr[mid]>arr[mid+1]){
9                high=mid;
10            }else{
11                low=mid+1;
12            }
13        }
14        return low;
15    }
16}