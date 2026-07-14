// Last updated: 7/14/2026, 8:59:15 AM
1class Solution {
2    public int numSubarraysWithSum(int[] nums, int goal) {
3        int n=nums.length;
4        return getAtmostSub(nums,goal)-getAtmostSub(nums,goal-1);
5    } 
6    public static int getAtmostSub(int nums[],int goal){
7        int n=nums.length;
8        if(goal<0) return 0;
9        int count=0;
10        int sum=0,left=0;
11        for(int right=0;right<n;right++){
12            sum+=nums[right];
13
14            while(sum>goal){
15                sum-=nums[left];
16                left++;
17            }
18            count+=(right-left+1);
19        }
20
21        return count;
22    }
23}