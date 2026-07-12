// Last updated: 7/12/2026, 11:13:31 PM
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int count=0;
   
          boolean seen[] = new boolean[n];
          int res[] = new int[n];
         
         for(int i=0;i<n;i++){
             if(seen[A[i]-1]) count++;
             else seen[A[i]-1]=true;
             
             if(seen[B[i]-1]) count++;
             else seen[B[i]-1]=true;
             
             res[i]=count;
         }
         
         return res;
    }
}