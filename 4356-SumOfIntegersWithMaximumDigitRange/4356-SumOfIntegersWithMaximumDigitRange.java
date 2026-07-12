// Last updated: 7/12/2026, 11:11:05 PM
class Solution {
    public int maxDigitRange(int[] nums) {
        int maxRange = -1;
        int sum = 0;
        
        for (int num : nums) {
            int currentRange = getDigitRange(num);
            
            // If we find a new maximum range, update maxRange and reset the sum
            if (currentRange > maxRange) {
                maxRange = currentRange;
                sum = num;
            } 
            // If it matches the current maximum range, add to the sum
            else if (currentRange == maxRange) {
                sum += num;
            }
        }
        
        return sum;
    }
    
    // Helper method to calculate the digit range of a number
    private int getDigitRange(int num) {
        int maxDigit = 0;
        int minDigit = 9;
        
        while (num > 0) {
            int digit = num % 10;
            maxDigit = Math.max(maxDigit, digit);
            minDigit = Math.min(minDigit, digit);
            num /= 10;
        }
        
        return maxDigit - minDigit;
    }
}