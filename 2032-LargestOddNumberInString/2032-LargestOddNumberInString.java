// Last updated: 7/12/2026, 11:15:12 PM
class Solution {
    public String largestOddNumber(String num) {
            String s="";

            for(int i=num.length()-1;i>=0;i--){
                int digit=num.charAt(i)-'0';
                if(digit%2==1){
                    s=num.substring(0,i+1);
                    break;
                }
            }
            return s;

    }
}