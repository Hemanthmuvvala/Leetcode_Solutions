// Last updated: 7/13/2026, 12:11:48 AM
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n=mat[0].length;
        int m=mat.length;
        int ans[] =new int[k];
        int index=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>( (a, b) -> {
                if(a[0] == b[0])
                    return a[1] - b[1]; 
                return a[0] - b[0]; 
            });
        for(int i=0;i<m;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            pq.offer(new int[]{count,i});
        }

        while(k>0){
            int curr[]=pq.poll();
            ans[index]=curr[1];
            index++;
            k--;
        }
        return ans;
    }
}