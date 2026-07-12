// Last updated: 7/12/2026, 11:11:58 PM
class Solution {
    public int minLengthAfterRemovals(String s) {
        int countA=0;
        int countB=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                countA++;
            }
            else{
                countB++;
            }
        }

        return Math.abs(countA-countB);
    }
}