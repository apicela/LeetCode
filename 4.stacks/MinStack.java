import java.util.ArrayList;
import java.util.Stack;

class MinStack {
    int length = -1;
    ArrayList<Integer> lista = new ArrayList<Integer>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        lista.add(val);
        length++;
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        } 
 
    }
    
    public void pop() {
        if(lista.get(length).equals(minStack.peek())) {
            minStack.pop();
        }      
        lista.remove(length);
        length--;
    }
    
    public int top() {
        return lista.get(length);
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
