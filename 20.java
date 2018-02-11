/**
水题。数组栈亦可。
**/

class Solution {
    private char getOpposite(char c) {
        switch (c) {
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';
        }
        return '\0';
    }

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if('(' == c || '{' == c || '[' == c) {
                stack.addLast(c);
            } else if (stack.isEmpty() || stack.getLast() != getOpposite(c)) {
                return false;
            } else {
                stack.removeLast();
            }
        }
        return stack.isEmpty();
    }
}
