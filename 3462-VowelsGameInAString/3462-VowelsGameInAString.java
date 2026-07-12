// Last updated: 7/12/2026, 11:13:10 PM
class Solution {
    public boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                return true; // Alice can always win if at least one vowel exists
            }
        }
        return false; // No vowels, Alice cannot move
    }
}
