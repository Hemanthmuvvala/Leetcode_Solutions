// Last updated: 7/14/2026, 11:15:04 PM
1class Solution {
2    public int numSubarrayProductLessThanK(int[] nums, int k) {
3       return getProduct(nums,k);
4    }
5
6    private static int getProduct(int nums[],int k){
7        int left=0;
8        int totalSubArr=0;
9        int product=1;
10        int n=nums.length;
11        if(k<=1) return 0;
12        for(int right=0;right<nums.length;right++){
13            product*=nums[right];
14            while(product>=k){
15                product=product/nums[left];
16                 left++;
17            }
18            totalSubArr+=right-left+1;
19        }
20        return totalSubArr;
21    }
22}