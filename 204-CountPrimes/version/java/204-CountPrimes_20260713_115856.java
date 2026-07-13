// Last updated: 7/13/2026, 11:58:56 AM
1class Solution {
2    public boolean isprime(int n){
3        if(n<2){
4            return false;
5        }
6        for(int i=2;i*i<=n;i++){
7            if(n%i==0){
8                return false;
9            }
10        }
11        return true;
12    }
13    public boolean completePrime(int num) {
14        String str=Integer.toString(num);
15        for(int i=0;i<str.length();i++){
16if(!isprime(Integer.parseInt((str.substring(0,i+1))))||!isprime(Integer.parseInt((str.substring(str.length()-1-i,str.length()))))){
17                return false;
18            }}
19        return true;
20        
21    }
22}