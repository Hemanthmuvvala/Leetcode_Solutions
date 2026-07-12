// Last updated: 7/12/2026, 11:11:16 PM
class Solution {
    public int scoreDifference(int[] nums) {
        boolean firstPlayer=true;
        boolean secondPlayer=false;

        int n=nums.length;
        int firstTotal=0,secondTotal=0;
        for(int i=0;i<n;i++){

            if(nums[i]%2!=0){
                firstPlayer=!firstPlayer;
                secondPlayer=!secondPlayer;
            }
            if((i+1)%6==0){
                firstPlayer=!firstPlayer;
                secondPlayer=!secondPlayer;
            }
            if(firstPlayer){
                firstTotal+=nums[i];
            }else{
                secondTotal+=nums[i];
            }
            
        }
        return firstTotal-secondTotal;
    }
}