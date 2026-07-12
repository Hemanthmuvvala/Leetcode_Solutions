// Last updated: 7/12/2026, 11:15:06 PM
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String s : patterns)
            if (word.contains(s)) count++;
        return count;
    }
}