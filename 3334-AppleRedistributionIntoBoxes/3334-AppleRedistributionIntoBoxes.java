// Last updated: 7/12/2026, 11:13:19 PM
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum=0,count=0;

        for(int i=0;i<apple.length;i++){
            sum=sum+apple[i];
        }
        Arrays.sort(capacity);

        for(int i=capacity.length-1;i>=0;i--){

            sum=sum-capacity[i];
            count++;

            if(sum<=0) break;


        }
        return count;

    }
}