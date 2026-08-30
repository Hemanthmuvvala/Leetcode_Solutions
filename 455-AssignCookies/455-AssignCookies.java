// Last updated: 8/30/2026, 9:37:17 PM
1class Solution {
2    public int findContentChildren(int[] g, int[] s) {
3        int i=0,j=0;
4        int n=g.length;
5        int m=s.length;
6        int count=0;
7        Arrays.sort(g);
8        Arrays.sort(s);
9        // for(int i=0;i<n;i++){
10        //     if(i<m){
11        //         for(int j=i;j<m;j++){
12        //             if(s[j]>=g[i]){
13        //                 count++;
14        //                 break;
15        //             }
16        //         }
17        //     }
18        // }
19        while(i<n && j<m){
20            if(s[j]>=g[i]){
21                count++;
22                i++;
23            }
24            j++;
25        }
26        return count;
27    }
28}