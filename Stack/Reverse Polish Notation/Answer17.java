import java.util.*;

public class Answer17 {

    public static int RPN(String str[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("+")) {
                int a = st.pop();
                int b = st.pop();
                st.push(a + b);
            } else if (str[i].equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } else if (str[i].equals("*")) {
                int a = st.pop();
                int b = st.pop();
                st.push(a * b);
            } else if (str[i].equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(a / b);
            } else {
                st.push(Integer.parseInt(str[i]));
            }
        }
        return st.pop();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the expression: ");
        int n = sc.nextInt();
        String str[] = new String[n];
        System.out.println("Enter the elements of the expression: ");
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        int ans = RPN(str);
        System.out.println("The result of the expression is: " + ans);
        sc.close();
    }
}
