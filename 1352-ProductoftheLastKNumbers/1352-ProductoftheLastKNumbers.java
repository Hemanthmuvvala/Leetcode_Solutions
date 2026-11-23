// Last updated: 11/23/2026, 10:10:27 AM
1class ProductOfNumbers {
2    List<Integer> a = new ArrayList<>();
3
4    public ProductOfNumbers() {}
5
6    public void add(int num) {
7        a.add(num);
8    }
9
10    public int getProduct(int k) {
11        int n = a.size(), prod = 1;
12        for (int i = n - k; i < n; i++)
13            prod *= a.get(i);
14        return prod;
15    }
16}
17/**
18 * Your ProductOfNumbers object will be instantiated and called as such:
19 * ProductOfNumbers obj = new ProductOfNumbers();
20 * obj.add(num);
21 * int param_2 = obj.getProduct(k);
22 */