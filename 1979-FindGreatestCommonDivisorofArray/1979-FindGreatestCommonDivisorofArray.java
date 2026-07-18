// Last updated: 7/18/2026, 9:11:17 AM
1class Solution {
2    public int findGCD(int[] nums) {
3        int max=Arrays.stream(nums).max().getAsInt();
4        int min=Arrays.stream(nums).min().getAsInt();
5
6        return gcd(max,min);
7
8    }
9    private static int gcd(int a,int b){
10        if(b==0)return Math.abs(a);
11        return gcd(b,a%b);
12    }
13}