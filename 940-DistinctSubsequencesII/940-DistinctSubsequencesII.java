// Last updated: 7/29/2026, 2:29:25 PM
1class Solution {
2    static int MOD=1_000_000_007;
3    public int distinctSubseqII(String S) {
4       int n=S.length();
5
6       int dp[]=new int[n+1];
7
8       dp[0]=1;
9       int arr[]=new int[26];
10        Arrays.fill(arr,-1);
11       for(int i=1;i<=n;i++){
12            int c=S.charAt(i-1)-'a';
13
14            dp[i]=dp[i-1]*2%MOD;
15            if(arr[c]!=-1){
16                dp[i] = (dp[i] - dp[arr[c] - 1] + MOD) % MOD;
17            }
18            arr[c]=i;
19       }
20       return (dp[n] - 1 + MOD) % MOD;
21    }
22
23}