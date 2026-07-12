// Last updated: 7/12/2026, 11:15:13 PM
import java.util.*;

class MovieRentingSystem {

    // Map (shop, movie) -> price
    private Map<String, Integer> priceMap;

    // For each movie -> available shops sorted by (price, shop)
    private Map<Integer, TreeSet<int[]>> available;

    // Global rented set sorted by (price, shop, movie)
    private TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        available = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2]; // price
            if (a[0] != b[0]) return a[0] - b[0]; // shop
            return a[1] - b[1]; // movie
        });

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            String key = shop + "#" + movie;
            priceMap.put(key, price);

            available.computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1]; // price
                return a[0] - b[0]; // shop
            }));
            available.get(movie).add(new int[]{shop, price});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        int count = 0;
        for (int[] x : available.get(movie)) {
            if (count == 5) break;
            res.add(x[0]); // shop
            count++;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        String key = shop + "#" + movie;
        int price = priceMap.get(key);

        available.get(movie).remove(new int[]{shop, price}); // remove from available
        rented.add(new int[]{shop, movie, price}); // add to rented
    }

    public void drop(int shop, int movie) {
        String key = shop + "#" + movie;
        int price = priceMap.get(key);

        rented.remove(new int[]{shop, movie, price});
        available.get(movie).add(new int[]{shop, price});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int[] x : rented) {
            if (count == 5) break;
            res.add(Arrays.asList(x[0], x[1])); // shop, movie
            count++;
        }
        return res;
    }
}
