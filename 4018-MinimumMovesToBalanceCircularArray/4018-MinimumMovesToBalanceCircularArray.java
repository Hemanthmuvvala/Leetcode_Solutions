// Last updated: 7/12/2026, 11:12:02 PM
class Solution {
    public long minMoves(int[] balance) {
        int n=balance.length;
        long sum=0;
        int neg=-1;

        for(int i=0;i<n;i++){
            sum=sum+balance[i];
            if(balance[i]<0) neg=i;
        }

        if(sum<0) return -1;
        if(neg==-1) return 0;

        long need = -balance[neg];
        long moves=0;

        for(int d=1;d<=n/2 && need>0;d++ ){
            int left=(neg-d+n)%n;
            
            if(balance[left]>0 && need>0){
                long take=Math.min(balance[left],need);
               // int dist =Math.min(Math.abs(i-neg),n- Math.abs(i-neg));
                moves += take * d;
                need -= take;
            }
            int right= (neg + d)%n;
            if(left!=right && balance[right]>0 && need>0){
                long take=Math.min(balance[right],need);
                moves += take *d;
                need -= take;
            }
        }
        return moves;
    }
}