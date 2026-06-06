class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                if (c == ']' || c == '}' || c == ')'){
                    if (stack.isEmpty() || !validMatches(stack.pop(), c)) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    static boolean validMatches(char a, char b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
        
    }
}
