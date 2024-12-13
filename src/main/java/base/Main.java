package base;
import java.util.Stack;

class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public int pop() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int popped = mainStack.pop();
        if (popped == minStack.peek()) {
            minStack.pop();
        }
        return popped;
    }

    public int min() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }

    public int peek() {
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return mainStack.peek();
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(5);
        stack.push(3);
        stack.push(7);
        System.out.println("Minimum: " + stack.min()); // Output: 3

        stack.pop();
        System.out.println("Minimum: " + stack.min()); // Output: 3

        stack.pop();
        System.out.println("Minimum: " + stack.min()); // Output: 5
    }
}
