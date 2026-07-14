// Last updated: 7/14/2026, 9:13:43 AM
1class Solution {
2    public int minOperations(int[] nums, int x) {
3        int n=nums.length;
4        int sum=0;
5        for(int val:nums){
6            sum+=val;
7        }
8        int target=sum-x;
9        int newSum=0,left=0,maxLen=-1;
10        for(int right=0;right<n;right++){
11            newSum+=nums[right];
12
13                while(newSum>target && left<=right){
14                    newSum-=nums[left];
15                    left++;
16                }
17            if(newSum==target){
18                maxLen=Math.max(maxLen,right-left+1);
19            }
20
21        }
22        return maxLen==-1 ?-1 :n-maxLen;
23    }
24}