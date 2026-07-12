// Last updated: 7/13/2026, 12:12:09 AM
class Solution {
    public boolean canReach(int[] arr, int start) {
        
        int n=arr.length;
        boolean visited[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        int temp=0;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>(n);

        visited[start]=true;
        q.add(start);

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
          if (i + arr[i] < n) {
        graph.get(i).add(i + arr[i]);
            }
                if (i - arr[i] >= 0) {
        graph.get(i).add(i - arr[i]);
             }

           }
        while(!q.isEmpty()){
             
            int current=q.poll();
          
            for(int i:graph.get(current)){
                if(!visited[i]){
                    visited[i]=true;
                    q.add(i);
                }
            }
            if(arr[current]==0){
                return true;
            }
        }

    //   if(arr[temp]==0){
    //     return true;
    //   }
        return false;
    }
}