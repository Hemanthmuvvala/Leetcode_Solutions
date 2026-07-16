// Last updated: 7/16/2026, 9:15:58 AM
1class Solution {
2    public int peakIndexInMountainArray(int[] arr) {
3        int n=arr.length;
4        int max=Integer.MIN_VALUE,index=-1;
5        for(int i=0;i<n;i++){
6           // max=Math.max(max,arr[i]);
7            if(arr[i]>max){
8                max=arr[i];
9                index=i;
10            }
11        }
12        return index;
13    }
14    
15}