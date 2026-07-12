// Last updated: 7/12/2026, 11:13:28 PM
class Solution {
    public String sortVowels(String s) {
        // Step 1: Collect vowels
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        // Step 2: Sort vowels by ASCII value
        Collections.sort(vowels);

        // Step 3: Rebuild the string with sorted vowels
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(vowelIndex++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    // Helper function to check vowel
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
