// Last updated: 7/13/2026, 12:11:43 AM
class Solution {
    public int maxScore(int[] cardPoints, int k) {
       
        int maxSum=0;
        int currentSum=0;
        int n=cardPoints.length;
        for(int i=0;i<k;i++){
            currentSum+=cardPoints[i];
        }
        maxSum=currentSum;
        for(int i=1;i<=k;i++){
            currentSum-=cardPoints[k-i];
            currentSum+=cardPoints[n-i];
            maxSum=Math.max(maxSum,currentSum);  
        }

        return maxSum;
    }
}