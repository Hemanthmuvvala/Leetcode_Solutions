// Last updated: 7/13/2026, 12:12:30 AM
class Solution {
    public int[] canSeePersonsCount(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            int count = 0;
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
                count++;
            }
            if (!st.isEmpty()) count++;
            ans[i] = count;
            st.push(i);
        }

        return ans;
    }
}
