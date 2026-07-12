// Last updated: 7/12/2026, 11:14:07 PM
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FoodRatings {

    /**
     * A helper class to store food items in the PriorityQueue.
     * It holds the food's name and its rating at a specific point in time.
     */
    private static class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    // Map: cuisine -> PriorityQueue of Foods for that cuisine.
    // The PriorityQueue is a max-heap ordered by rating, then by lexicographically smaller name.
    private final Map<String, PriorityQueue<Food>> cuisineFoodsMap;

    // Map: food name -> cuisine name.
    // Used to quickly find which cuisine's PriorityQueue to update.
    private final Map<String, String> foodCuisineMap;

    // Map: food name -> current rating.
    // This is the "source of truth" for ratings, essential for handling lazy updates in the PriorityQueue.
    private final Map<String, Integer> foodRatingMap;

    /**
     * Initializes the food rating system.
     * @param foods Array of food names.
     * @param cuisines Array of corresponding cuisine types.
     * @param ratings Array of corresponding initial ratings.
     */
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineFoodsMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        foodRatingMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            // Store the food's cuisine and initial rating.
            foodCuisineMap.put(food, cuisine);
            foodRatingMap.put(food, rating);

            // Get or create the priority queue for the cuisine.
            // The lambda defines the custom sorting:
            // 1. Higher rating comes first (b.rating vs a.rating).
            // 2. If ratings are tied, lexicographically smaller name comes first (a.name vs b.name).
            cuisineFoodsMap.computeIfAbsent(cuisine, k -> new PriorityQueue<>((a, b) -> {
                if (a.rating != b.rating) {
                    return Integer.compare(b.rating, a.rating);
                }
                return a.name.compareTo(b.name);
            }));

            // Add the new food to the corresponding cuisine's PriorityQueue.
            cuisineFoodsMap.get(cuisine).add(new Food(food, rating));
        }
    }

    /**
     * Changes the rating of a food item.
     * @param food The name of the food to update.
     * @param newRating The new rating for the food.
     */
    public void changeRating(String food, int newRating) {
        // Update the canonical rating in our source-of-truth map.
        foodRatingMap.put(food, newRating);

        // Find the cuisine of the food.
        String cuisine = foodCuisineMap.get(food);

        // Add a new entry with the updated rating to the PriorityQueue.
        // The old entry for this food is now "stale" but is left in the queue
        // to be filtered out later. This is a "lazy update".
        cuisineFoodsMap.get(cuisine).add(new Food(food, newRating));
    }

    /**
     * Returns the highest-rated food for a given cuisine.
     * @param cuisine The type of cuisine.
     * @return The name of the food with the highest rating.
     */
    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisineFoodsMap.get(cuisine);

        // The top of the PriorityQueue is a candidate for the highest-rated food.
        // However, it might be a stale entry from before a rating change.
        // We must check if its rating matches the current, true rating.
        while (true) {
            Food topFood = pq.peek();
            
            // If the rating in the priority queue matches the current rating in our map,
            // it's a valid, up-to-date entry and is the current highest-rated food.
            if (topFood.rating == foodRatingMap.get(topFood.name)) {
                return topFood.name;
            }
            
            // If the ratings don't match, this is a stale entry. Remove it and
            // check the next element at the top of the queue.
            pq.poll();
        }
    }
}