// Last updated: 7/12/2026, 11:14:59 PM
class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        int lastConsonant = -1;
        int[] lastSeen = { -1, -1, -1, -1, -1 }; 
        String vowels = "aeiou";
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int vowelIndex = vowels.indexOf(c);  
            if (vowelIndex == -1) {
                lastConsonant = i;
            } else {
                lastSeen[vowelIndex] = i;
                int minVowelIndex = lastSeen[0];
                for (int j = 1; j < 5; j++) {
                    minVowelIndex = Math.min(minVowelIndex, lastSeen[j]);
                }
                if (minVowelIndex > lastConsonant) {
                    count += (minVowelIndex - lastConsonant);
                }
            }
        }
        return count;
    }
}