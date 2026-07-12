// Last updated: 7/12/2026, 11:11:14 PM
class Solution {
    public String trimTrailingVowels(String s) {
        int n=s.length();
        int end=n-1;


        while(end>=0 && isVowel(s.charAt(end))){
            end--;
        }

        return s.substring(0,end+1);
    }

    private static boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u'; 
    }
}