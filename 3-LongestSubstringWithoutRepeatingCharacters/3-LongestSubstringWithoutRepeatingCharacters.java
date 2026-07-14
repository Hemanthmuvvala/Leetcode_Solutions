// Last updated: 7/14/2026, 11:10:42 PM
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int n=s.length();
4        int maxLength=0;
5        HashSet<Character> seen=new HashSet<>();
6        int left=0;
7
8        for(int right=0;right<n;right++){
9
10            while(seen.contains(s.charAt(right))){
11                seen.remove(s.charAt(left));
12                left++;
13            }
14            seen.add(s.charAt(right));
15        maxLength=Math.max(maxLength,right-left+1);
16        }
17
18        return maxLength;
19    }
20}