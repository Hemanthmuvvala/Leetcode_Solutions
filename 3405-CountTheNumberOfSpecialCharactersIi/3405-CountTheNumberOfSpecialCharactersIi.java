// Last updated: 7/12/2026, 11:13:14 PM
class Solution {
    public int numberOfSpecialChars(String word) {

        int[] firstUpper = new int[26];
        int[] lastLower = new int[26];

        for (int i = 0; i < 26; i++) {
            firstUpper[i] = -1;
            lastLower[i] = -1;
        }

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            if (c >= 'a' && c <= 'z') {

                lastLower[c - 'a'] = i;

            } else {

                if (firstUpper[c - 'A'] == -1) {
                    firstUpper[c - 'A'] = i;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {

            if (lastLower[i] != -1 &&
                firstUpper[i] != -1 &&
                lastLower[i] < firstUpper[i]) {

                count++;
            }
        }

        return count;
    }
}