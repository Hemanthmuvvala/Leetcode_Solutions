// Last updated: 7/12/2026, 11:12:23 PM
class Solution {
    public String processStr(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();

        for(char c:s.toCharArray()){

            if(c=='*'){
                if (sb.length() > 0) {
        sb.deleteCharAt(sb.length() - 1);
            }
            }
            else if(c=='#'){
                sb.append(sb);
            }else if(c=='%'){
                sb.reverse();
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}