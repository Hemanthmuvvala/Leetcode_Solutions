// Last updated: 7/12/2026, 11:11:08 PM
class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int n=capacity.length;
        int min=Integer.MAX_VALUE;
        int index=-1;
        //Stack<Integer> st=new Stack<>();
        // for(int i=0;i<n;i++){

        //     while(!st.isEmpty() && capacity[st.peek()]<=itemSize) st.pop();

        //     st.push(i);
        // }

        // return st.peek()> -1 ? st.peek() : -1;
        for(int i=0;i<n;i++){
            if(capacity[i]>=itemSize){
               
                if(capacity[i]<min){
                     min=capacity[i];
                    index=i;
                }
                   
            }
        }

        return index==Integer.MAX_VALUE ? -1 :index;
    }
}