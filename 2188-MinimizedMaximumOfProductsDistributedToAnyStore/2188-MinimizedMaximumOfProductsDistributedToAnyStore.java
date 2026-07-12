// Last updated: 7/12/2026, 11:14:58 PM
class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        if(n==1) return quantities[0];
        int max=0;
        int min=1;
        for(int i=0;i<quantities.length; i++){
            max = Math.max(max, quantities[i]);
        }

        while(min<=max){
            int mid = min + (max-min)/2;
            if(isValid(n, quantities, mid)){
                max = mid-1;
            } else {
                min = mid+1;
            }
        }

        return min;

    }

    public boolean isValid(int n, int[] qts, int k){
        for(int i=0; i<qts.length; i++){
            if(qts[i]<=k){
                n--;
            } else {
                n = n - ((qts[i] + k-1)/k);
            }
        }

        return n>=0;
    }
}