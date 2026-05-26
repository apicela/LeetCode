import java.util.Stack;

class ValidParentheses {
    public static boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if(stack.isEmpty() &&( c == ']' || c == ')' || c == '}' )) return false;
            else if(c == ']' || c == ')' || c == '}' ){
                if(c == ']' && stack.pop() != '[' ) return false;
                if(c == ')' && stack.pop() != '(' ) return false;
                if(c == '}' && stack.pop() != '{' ) return false;
            }
            else stack.add(c);
        }
        return stack.isEmpty();
    }

}
