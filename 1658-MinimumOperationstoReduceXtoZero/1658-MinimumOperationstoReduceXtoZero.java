// Last updated: 7/14/2026, 3:50:57 PM
1class Solution {
2    public boolean isAnagram(String s, String t) {
3        // int freq[]=new int[26];
4
5        // if(s.length()!=t.length())
6        //     return false;
7
8        // for(char c:s.toCharArray()){
9        //     freq[c-'a']++;
10        // }
11        //  for(char c:t.toCharArray()){
12        //     freq[c-'a']--;
13
14        //     if(freq[c-'a']<0)
15        //         return false;
16        // }
17
18        // return true;
19        if (s.length() != t.length())
20        return false;
21        HashMap<Character, Integer> map = new HashMap<>();
22
23        for (int i = 0; i < s.length(); i++) {
24            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
25        }
26
27        for (int i = 0; i < t.length(); i++) {
28            if (!map.containsKey(t.charAt(i))) {
29                return false;
30            }
31
32            if (map.get(t.charAt(i)) <= 0) {
33                return false;
34            }
35
36            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
37        }
38
39        return true;
40    }
41}