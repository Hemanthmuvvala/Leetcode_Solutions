// Last updated: 7/13/2026, 11:20:25 AM
1class Solution {
2public:
3    int countPrimes(int n) {
4        if (n <= 2) return 0;
5        vector<bool> isPrime(n, true);
6        int ans = 1; 
7        
8        for (int i = 3; i * i < n; i += 2) {
9            if (isPrime[i]) {
10                for (int j = i * i; j < n; j += 2 * i) {
11                    isPrime[j] = false;
12                }
13            }
14        }
15        
16        for (int i = 3; i < n; i += 2) {
17            if (isPrime[i]) {
18                ans++;
19            }
20        }
21        
22        return ans;
23    }
24};