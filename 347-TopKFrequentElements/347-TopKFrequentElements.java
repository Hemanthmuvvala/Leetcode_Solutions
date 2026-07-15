// Last updated: 7/15/2026, 2:44:40 PM
1class Solution {
2    public List<String> topKFrequent(String[] words, int k) {
3        HashMap<String, Integer> map = new HashMap<>();
4        for (String word : words) {
5            map.put(word, map.getOrDefault(word, 0) + 1);
6        }
7        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
8        list.sort((a, b) -> {
9            if (!a.getValue().equals(b.getValue())) {
10                return b.getValue().compareTo(a.getValue());
11            }
12            return a.getKey().compareTo(b.getKey());
13        });
14        List<String> l1=new ArrayList<>();
15        for (int i = 0; i < k; i++) {
16             l1.add(list.get(i).getKey());
17        }
18        return l1;
19    }
20}
21