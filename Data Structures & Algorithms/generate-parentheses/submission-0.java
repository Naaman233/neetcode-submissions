class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        Stack<Character> parenthesisContainer = new Stack<>();
        parenthesisGenerator(n,0,0,result,parenthesisContainer);
        return result;
    }

    private void parenthesisGenerator(int n, int openCount, int closeCount, List<String> res, Stack<Character> s) {

        if ( openCount == n && openCount == closeCount ) {

            StringBuilder b = new StringBuilder();
            for (char c : s) {
                b.append(c);
            }

            res.add(b.toString());
            return;
        }

        if (openCount < n) {
            s.push('(');
            parenthesisGenerator(n,openCount + 1, closeCount, res,s);
            s.pop();
        }

        if (closeCount < openCount) {
            s.push(')');
            parenthesisGenerator(n,openCount, closeCount + 1, res, s);
            s.pop();
        }
    }
}


