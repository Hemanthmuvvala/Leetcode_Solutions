// Last updated: 7/12/2026, 11:11:59 PM
class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;

        for (int i = num1; i <= num2; i++) {
            String newStr = String.valueOf(i);

            if (newStr.length() < 3) continue;

            for (int j = 1; j < newStr.length() - 1; j++) {

                if ((newStr.charAt(j) - '0') < (newStr.charAt(j - 1) - '0') &&
                    (newStr.charAt(j) - '0') < (newStr.charAt(j + 1) - '0')) {
                    count++;
                } 
                else if ((newStr.charAt(j) - '0') > (newStr.charAt(j - 1) - '0') &&
                         (newStr.charAt(j) - '0') > (newStr.charAt(j + 1) - '0')) {
                    count++;
                }
            }
        }

        return count;
    }
}