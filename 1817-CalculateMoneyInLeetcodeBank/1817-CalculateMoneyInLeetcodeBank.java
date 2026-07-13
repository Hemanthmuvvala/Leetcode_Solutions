// Last updated: 7/13/2026, 9:25:15 AM
class Solution {
    public int totalMoney(int n) {
        int res=0;
       // int sum=0;
        if(n<=7){
            res=n*(n+1)/2;
           
        }
        else{

            int weeks=n/7;
            int days=n%7;
            int l=0;
            for(int i=1;i<=weeks;i++){
                res+=(28+l);
                l+=7;
            }

            for(int i=1;i<=days;i++){
                res+=(weeks+i);
            }
        }
        return res;
    }
}