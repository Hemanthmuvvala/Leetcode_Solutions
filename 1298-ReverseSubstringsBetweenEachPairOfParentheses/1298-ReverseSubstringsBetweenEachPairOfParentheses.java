// Last updated: 7/13/2026, 12:12:31 AM
class Solution {
    public String reverseParentheses(String s) {
        return getString(s, 0, s.length());
    }

    private static String getString(String s, int start, int end) {

        if (start>=end)
            return "";

        StringBuilder sb = new StringBuilder();

        for (int i = start; i < end; i++) {

            char c = s.charAt(i);

            if (c == '(') {
                int balance = 1;
                int closingIndex = i + 1;

                while (balance > 0) {
                    if (s.charAt(closingIndex) == '(')
                        balance++;
                    if (s.charAt(closingIndex) == ')')
                        balance--;
                    closingIndex++;
                }
                String st = getString(s, i + 1, closingIndex - 1);
                StringBuilder sb2 = new StringBuilder(st).reverse();
                sb.append(sb2);
                i = closingIndex - 1;

            }else{
                sb.append(c);
            }

        }
        return sb.toString();
    }
}