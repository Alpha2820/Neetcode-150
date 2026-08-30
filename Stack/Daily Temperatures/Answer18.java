import java.util.*;

public class Answer18 {

    public static int[] dailyTemperatures(int arr[]) {
        int result[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while ((!st.isEmpty()) && (arr[i] > arr[st.peek()])) {
                int prevIndex = st.pop();
                result[prevIndex] = i - prevIndex;
            }
            st.push(i);
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of days: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the temperatures for each day: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans[] = dailyTemperatures(arr);
        System.out.println("The number of days until a warmer temperature for each day is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        sc.close();
    }
}
