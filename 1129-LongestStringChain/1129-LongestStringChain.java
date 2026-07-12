// Last updated: 7/13/2026, 12:12:44 AM
class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);

        Arrays.sort(words,(a,b)->a.length()-b.length());
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(compareWords(words[i],words[j]) && dp[i]<1+dp[j]){
                    dp[i]=dp[j]+1;
                }
            }
            max=Math.max(max,dp[i]);
        }

        return max;
    }

    public static boolean compareWords(String a,String b){
        if(a.length()!=b.length()+1) return false;

        int first=0;
        int second=0;

        while(first < a.length()){
            if(second < b.length() && a.charAt(first) == b.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }

        return second==b.length(); 
    }
}