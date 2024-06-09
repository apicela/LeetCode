import java.util.Stack;

public class LeetCode20 {
    public static void main(String[] args) {
        var leet = new LeetCode20();
        String s = "(";
        System.out.println(leet.isValid(s));
    }
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack<>();
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if( c == '(' || c == '{' || c == '['){
                stack.add(c);
            } else{
                if(stack.isEmpty()) return false;
                if(c == ')' && stack.pop() != '(') return false;
                else if(c == '}' && stack.pop() != '{') return false;
                else if(c == ']' && stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
