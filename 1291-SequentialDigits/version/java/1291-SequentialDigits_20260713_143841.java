// Last updated: 7/13/2026, 2:38:41 PM
1class Solution {
2    public List<Integer> sequentialDigits(int low, int high) {
3        String brute="123456789";
4        List<Integer> ans=new ArrayList<>();
5        String sLow=String.valueOf(low);
6        String sHigh=String.valueOf(high);
7        for(int i=sLow.length();i<=sHigh.length();i++){
8            for(int j=0;j<=9-i;j++){
9                int val=Integer.parseInt(brute.substring(j,j+i));
10                if(val>=low && val<=high){
11                    ans.add(val);
12                }
13            }
14        }
15        return ans;
16    }
17}