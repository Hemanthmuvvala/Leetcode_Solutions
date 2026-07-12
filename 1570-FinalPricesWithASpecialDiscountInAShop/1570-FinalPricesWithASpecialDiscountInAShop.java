// Last updated: 7/13/2026, 12:11:32 AM
class Solution {
    public int[] finalPrices(int[] nums) {
        int n=nums.length;

        Stack<Integer> st=new Stack<>();
        int nextSmaller[] = new int[n];
        int discount[] = new int[n];
        for(int i=n-1;i>=0;i--){

            while(!st.isEmpty() && st.peek()>nums[i]){
                st.pop();
            }
               nextSmaller[i] = !st.isEmpty() ? st.peek() : 0;
                st.push(nums[i]);
        } 
       for(int i=0;i<n;i++){
            discount[i]=nums[i]-nextSmaller[i];
       }

       return discount;
    }
}