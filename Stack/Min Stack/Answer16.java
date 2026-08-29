import java.util.*;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);

    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }

}

public class Answer16 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements to be pushed into the stack: ");
        int n = sc.nextInt();
        MinStack minStack = new MinStack();
        System.out.println("Enter the elements to be pushed into the stack: ");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            minStack.push(val);
        }
        System.out.println("The minimum element in the stack is: " + minStack.getMin());
        sc.close();
    }
}
