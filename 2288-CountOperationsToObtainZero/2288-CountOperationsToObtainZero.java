// Last updated: 7/12/2026, 11:14:27 PM
class Solution {
    public int countOperations(int num1, int num2) {
        int count=0;

        while(num2>0 && num1>0){
            if(num1<=num2){
                num2=num2-num1;
              
            }
            else{
                num1=num1-num2;
               
            }
            count++;
        }
        return count;
    }
}