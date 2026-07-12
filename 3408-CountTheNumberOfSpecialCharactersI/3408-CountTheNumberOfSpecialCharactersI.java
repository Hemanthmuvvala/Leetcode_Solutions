// Last updated: 7/12/2026, 11:13:13 PM
class Solution {
    public int numberOfSpecialChars(String word) {
        boolean smallLetter[]=new boolean[26];
        boolean capitalLetter[]=new boolean[26];
        int count=0;

        for(char c:word.toCharArray()){
            if(c>='a' && c<='z') smallLetter[c-'a']=true;
            else capitalLetter[c-'A']=true;
        }

        for(int i=0;i<smallLetter.length;i++){
            if(smallLetter[i] && capitalLetter[i]) count++;
        }

        return count;
    }
}