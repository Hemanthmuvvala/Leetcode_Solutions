// Last updated: 7/12/2026, 11:13:09 PM
class Solution {
    public int minimumOperations(int[] arr) {
       int n=arr.length;
       int count=0;

       for(int i=0;i<n;i++){

            if(arr[i]%3!=0){
                if((arr[i]+1)%3==0 ||(arr[i]-1)%3==0){
                    count++;
                }
            }

       }
       return count;
    }
}