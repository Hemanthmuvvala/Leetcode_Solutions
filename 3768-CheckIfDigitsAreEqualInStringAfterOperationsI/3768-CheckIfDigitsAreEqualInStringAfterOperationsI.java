// Last updated: 7/12/2026, 11:12:34 PM
class Solution {
    public static boolean hasSameDigits(String s) {
        int n=s.length();
        if(n==0||n==1)
            return false;
        char[] chars=s.toCharArray();
        while(n>2) {
            for(int i=0;i<n-1;i++) {
                int temp=((chars[i]-'0')+(chars[i+1]-'0'))%10;
                chars[i]=(char)(temp+'0');
            }
            n--;
        }
        if(chars[0]==chars[1])
            return true;
        return false;
    }
}