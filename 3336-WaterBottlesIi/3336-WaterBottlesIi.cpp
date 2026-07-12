// Last updated: 7/12/2026, 11:13:17 PM
class Solution {
public:
    int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalDrunk = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            empty -= numExchange;
            totalDrunk++;
            empty++;
            numExchange++;
        }
        return totalDrunk;
    }
};
