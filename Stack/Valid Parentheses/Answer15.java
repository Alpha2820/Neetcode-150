import java.util.*;

public class Answer15 {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (st.isEmpty() && (ch == ')' || ch == ']' || ch == '}')) {
                return false;
            }
            if (ch == ')' && st.peek() == '(') {
                st.pop();
            } else if (ch == '}' && st.peek() == '{') {
                st.pop();
            } else if (ch == ']' && st.peek() == '[') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        return st.isEmpty();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string of parentheses: ");
        String str = sc.nextLine();
        if (isValid(str)) {
            System.out.println("The parentheses are valid.");
        } else {
            System.out.println("The parentheses are not valid.");
        }
        sc.close();
    }
}

// Time Complexity: O(n) - We traverse the string once, and each character is
// pushed and popped from the stack at most once, leading to linear time
// complexity.

// Space Complexity: O(n) - We use a stack to keep track of the opening
// parentheses, which can take up to O(n) space in the worst case.
