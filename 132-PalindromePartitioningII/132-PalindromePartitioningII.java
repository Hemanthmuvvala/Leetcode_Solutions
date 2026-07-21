// Last updated: 7/21/2026, 10:04:20 PM
1class Solution {
2    public int minCut(String s) {
3        int n=s.length();
4        int dp[]=new int[n];
5
6        Arrays.fill(dp,-1);
7
8        return getMin(0,dp,s)-1;
9    }
10
11    public static int getMin(int index,int dp[],String s){
12
13        if(index==s.length())return 0;
14
15        if(dp[index]!=-1) return dp[index];
16        int min=Integer.MAX_VALUE;
17        int count=0;
18        for(int i=index;i<s.length();i++){
19
20            if(isPalindrome(index,i,s)){
21                 count=1+getMin(i+1,dp,s);
22            }
23            min=Math.min(min,count);
24        }
25
26        return dp[index]=min;   
27    }
28    public static boolean isPalindrome(int i,int j,String s){
29        
30       while(i<=j){
31
32        if(s.charAt(i)!=s.charAt(j)) return false;
33
34        i++;
35        j--;
36       }
37        return true;
38    }
39}