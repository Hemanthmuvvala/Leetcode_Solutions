// Last updated: 7/12/2026, 11:11:18 PM
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {

        StringBuilder ans = new StringBuilder();
        for (String s : words) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                cnt += weights[s.charAt(i) - 'a'];
            }
            int x=cnt%26;
            ans.append((char)('z'-x));
        }
        return ans.toString();
    }
}