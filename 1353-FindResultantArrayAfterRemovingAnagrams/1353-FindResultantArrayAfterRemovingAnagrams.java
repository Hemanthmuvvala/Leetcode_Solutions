// Last updated: 7/13/2026, 12:12:23 AM
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (res.isEmpty()) {
                res.add(w);
            } else {
                char[] a = w.toCharArray();
                char[] b = res.get(res.size() - 1).toCharArray();
                Arrays.sort(a);
                Arrays.sort(b);
                if (!Arrays.equals(a, b)) res.add(w);
            }
        }
        return res;
    }
}