// Last updated: 7/14/2026, 11:46:56 PM
1class Solution {
2    public double findMaxAverage(int[] nums, int k) {
3      
4        double sum=0;
5        for(int i=0;i<k;i++){
6             sum=sum+nums[i];
7        }
8        double max=sum/k;
9        for(int i=k;i<nums.length;i++){
10             sum+=nums[i]-nums[i-k];
11            max=sum/k>max?sum/k:max;
12        }
13        return max;
14        
15    }
16}