// Last updated: 7/17/2026, 9:12:29 AM
1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int rowLength=matrix.length;
4        int colLength=matrix[0].length;
5        int low=0;
6        int high=rowLength*colLength-1;
7
8        while(low<=high){
9
10            int mid=(low+high)/2;
11            int row=mid/colLength;
12            int col=mid%colLength;
13
14            if(matrix[row][col]==target){
15                return true;
16            }else if(matrix[row][col]<target){
17                 low=mid+1;
18            }else{
19                 high=mid-1;
20              
21            }
22        }
23
24
25        return false;
26    }
27}