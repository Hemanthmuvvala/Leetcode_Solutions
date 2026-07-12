// Last updated: 7/13/2026, 12:10:56 AM
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        String res = s;
        q.add(s);
        seen.add(s);
        int n = s.length();
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(res) < 0) res = cur;
            char[] arr = cur.toCharArray();
            for (int i = 1; i < n; i += 2) arr[i] = (char) ((arr[i] - '0' + a) % 10 + '0');
            String add = new String(arr);
            if (seen.add(add)) q.add(add);
            String rot = cur.substring(n - b) + cur.substring(0, n - b);
            if (seen.add(rot)) q.add(rot);
        }
        return res;
    }
}