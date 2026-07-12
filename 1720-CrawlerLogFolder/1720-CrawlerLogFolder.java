// Last updated: 7/13/2026, 12:10:57 AM
class Solution {
    public int minOperations(String[] logs) {
        
        int count=0;
        Stack<String> st=new Stack<>();
        for(String s:logs){

             if (s.equals("../")) {
                if (!st.isEmpty()) st.pop();
            }
            else if(!s.equals("./")){
                st.push(s);
            }
        }

        

        return st.size();
    }
}