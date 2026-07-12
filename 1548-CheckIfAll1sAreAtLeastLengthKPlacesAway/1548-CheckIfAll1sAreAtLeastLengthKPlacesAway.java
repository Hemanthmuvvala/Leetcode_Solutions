// Last updated: 7/13/2026, 12:11:41 AM
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int first=0;
        int second=0;
        int value=k;
        boolean kLen=false;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==1){
              
                value=second-first;
                second++;
                first=i;
               
            }
            else{
                second++;
               
            }
            if(value>=k){
                kLen=true;
            
            }else{
                kLen=false;
            }
        }
        // if(second==0 || second==1){
        //     kLen=true;
        // }
        return kLen;
    }
}