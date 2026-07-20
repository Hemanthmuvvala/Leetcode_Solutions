// Last updated: 7/20/2026, 10:35:52 AM
1class Solution {
2    public boolean parseBoolExpr(String expression) {
3
4        Stack<Character> stack = new Stack<>();
5
6        for (char ch : expression.toCharArray()) {
7
8            if (ch == ',') continue;
9
10            if (ch != ')') {
11                stack.push(ch);
12            } else {
13
14                boolean hasTrue = false;
15                boolean hasFalse = false;
16
17                while (stack.peek() != '(') {
18                    char cur = stack.pop();
19
20                    if (cur == 't') hasTrue = true;
21                    else if (cur == 'f') hasFalse = true;
22                }
23
24                stack.pop();
25
26                char op = stack.pop();
27
28                char result = 'f';
29
30                if (op == '!') {
31                    result = hasTrue ? 'f' : 't';
32                } else if (op == '&') {
33                    result = hasFalse ? 'f' : 't';
34                } else if (op == '|') {
35                    result = hasTrue ? 't' : 'f';
36                }
37
38                stack.push(result);
39            }
40        }
41
42        return stack.pop() == 't';
43    }
44}