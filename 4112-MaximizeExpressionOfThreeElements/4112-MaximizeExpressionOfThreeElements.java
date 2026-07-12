// Last updated: 7/12/2026, 11:11:55 PM
class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int firstMax=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        int smallestVal=Integer.MAX_VALUE;

       

        for(int i=0;i<nums.length;i++){
            smallestVal=Math.min(smallestVal,nums[i]);
            
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>firstMax){
                secondMax=firstMax;
             
                firstMax=nums[i];  
              
            }
            else if(nums[i]>secondMax && nums[i]<=firstMax){
                secondMax=nums[i];
               
            }
        }

        

        return (firstMax+secondMax-smallestVal);
    }
}