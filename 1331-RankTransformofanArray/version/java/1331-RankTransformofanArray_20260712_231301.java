// Last updated: 7/12/2026, 11:13:01 PM
1class Solution {
2    public int[] arrayRankTransform(int[] arr) {
3        int n = arr.length;
4        int ans[] = new int[n];
5        int dup[] = new int[n];
6        int index = 0;
7
8        HashMap<Integer, Integer> map = new HashMap<>();
9
10        for(int i : arr){
11            dup[index++] = i;
12        }
13        Arrays.sort(dup);
14
15        int rank = 1;
16        for(int i = 0; i < n; i++){
17            if(!map.containsKey(dup[i])){
18                map.put(dup[i], rank++);
19            }
20        }
21        for(int i = 0; i < n; i++){
22            ans[i] = map.get(arr[i]);
23        }
24
25        return ans;
26    }
27}