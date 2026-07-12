// Last updated: 7/12/2026, 11:11:07 PM
class Solution {
    public List<String> generateValidStrings(int n, int k) {
        int l=n;

        List<String> ans=new ArrayList<>();
        backtrack(0,n,k,0,new StringBuilder(),ans);
        return ans;
    }

    private static void backtrack(int idx,int n,int maxCost,int cost,StringBuilder sb,List<String> ans){
        if(idx==n){
            ans.add(sb.toString());
            return ;
        }
        sb.append('0');
        backtrack(idx+1,n,maxCost,cost,sb,ans);
        sb.deleteCharAt(sb.length()-1);
        boolean canPlace=(sb.length() == 0 || sb.charAt(sb.length()-1)!='1') && (cost + idx <= maxCost);

        if(canPlace){
            sb.append('1');
            backtrack(idx+1,n,maxCost,cost+idx,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}