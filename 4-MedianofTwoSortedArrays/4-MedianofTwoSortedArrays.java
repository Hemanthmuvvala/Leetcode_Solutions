// Last updated: 7/17/2026, 2:17:44 PM
1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3
4            int n1=nums1.length;
5            int n2=nums2.length;
6           
7            int i=0,j=0;
8            int arr[]=new int[n1+n2];
9             int arr_length=arr.length;
10            int index=0;
11            while(i<n1 && j<n2){
12
13                if(nums1[i]<nums2[j]){
14                    arr[index]=nums1[i];
15                    index++;
16                    i++;
17                }else{
18                    arr[index]=nums2[j];
19                    j++;
20                    index++;
21                }
22            }
23
24            while(i<n1){
25                arr[index]=nums1[i];
26                    index++;
27                    i++;
28            }
29            while(j<n2){
30                arr[index]=nums2[j];
31                    index++;
32                    j++;
33            }
34
35            double median=0;
36
37            if(arr.length%2==0){
38                median=arr[arr_length/2]+arr[(arr_length/2)-1];
39                median=median/2;
40            }else{
41                median=arr[arr_length/2];
42            }
43
44            return median;
45    }
46}