import java.util.*;

public class Answer20 {

    public static int LargestReactangleInHistogram(int arr[]) {
        int maxArea = 0;
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while ((!st.isEmpty()) && (i == n || arr[i] <= arr[st.peek()])) {
                int height = arr[st.peek()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(null);
        }
        return maxArea;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements of the Array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = LargestReactangleInHistogram(arr);
        System.out.println("The largest rectangle in the histogram is: " + ans);
        sc.close();
    }
}

// Time Complexity: O(n) - We traverse the array once, and each index is pushed
// and popped from the stack at most once, leading to linear time complexity.

// Space Complexity: O(n) - We use a stack to keep track of the indices of the
// histogram bars, which can take up to O(n) space in the worst case.