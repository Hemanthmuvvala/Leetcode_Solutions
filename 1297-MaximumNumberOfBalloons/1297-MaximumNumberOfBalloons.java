// Last updated: 7/13/2026, 12:12:33 AM
class Solution {
    public int maxNumberOfBalloons(String text) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : text.toCharArray()) {

            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        while (map.getOrDefault('b', 0) > 0 &&
                map.getOrDefault('a', 0) > 0 &&
                map.getOrDefault('l', 0) > 1 &&
                map.getOrDefault('o', 0) > 1 &&
                map.getOrDefault('n', 0) > 0) {
            count++;
            map.put('b', map.get('b') - 1);
            map.put('a', map.get('a') - 1);
            map.put('l', map.get('l') - 2);
            map.put('o', map.get('o') - 2);
            map.put('n', map.get('n') - 1);
        }
        return count;
    }
}