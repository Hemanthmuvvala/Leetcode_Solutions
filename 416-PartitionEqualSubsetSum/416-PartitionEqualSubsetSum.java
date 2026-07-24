// Last updated: 7/24/2026, 11:00:50 PM
1class Solution {
2    public boolean canPartition(int[] nums) {
3        int n=nums.length;
4        int sum=0;
5
6        for(int val:nums){
7            sum+=val;
8        }
9        if(sum%2!=0) return false;
10        int targetSum=sum/2;
11        return subsetSumToK(n,targetSum,nums);
12    }
13
14    public boolean subsetSumToK(int n, int k, int[] arr) {
15      
16        if (n == 0) return k == 0;
17
18       
19        boolean[] prev = new boolean[k + 1];
20
21      
22        prev[0] = true;
23
24       
25        if (arr[0] <= k) {
26            prev[arr[0]] = true;
27        }
28
29        for (int ind = 1; ind < n; ind++) {
30
31            boolean[] curr = new boolean[k + 1];
32            
33         
34            curr[0] = true;
35
36            for (int target = 1; target <= k; target++) {
37                
38                boolean notTaken = prev[target];
39                boolean taken = false;
40                if (arr[ind] <= target) {
41                    taken = prev[target - arr[ind]];
42                }
43
44            
45                curr[target] = notTaken || taken;
46            }
47            
48        
49            prev = curr;
50        }
51
52        
53        return prev[k];
54    }
55}