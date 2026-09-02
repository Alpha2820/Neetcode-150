import java.util.*;

public class Answer21 {

    public static int maxProfit(int arr[]) {
        int left = 0;
        int right = 0;
        int maxProfit = 0;
        while (right < arr.length) {
            if (arr[left] <= arr[right]) {
                int profit = arr[right] - arr[left];
                maxProfit = Math.max(maxProfit, profit);
            } else if (arr[left] > arr[right]) {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = maxProfit(arr);
        if (ans == 0) {
            System.out.println("No profit can be made");
        } else {
            System.out.println("The maximum profit that can be made is: " + ans);
        }
        sc.close();
    }
}
