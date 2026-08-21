import java.util.*;

public class Answer11 {

    public static int[] twoSumSorted(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int value = arr[left] + arr[right];
            if (value > target) {
                right--;
            } else if (value < target) {
                left++;
            } else {
                return new int[] { left + 1, right + 1 };
            }

        }
        return new int[] { -1, -1 };
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
        System.out.println("Enter the target value");
        int target = sc.nextInt();
        int[] ans = twoSumSorted(arr, target);
        if (ans[0] == -1 && ans[1] == -1) {
            System.out.println("No two numbers found that add up to the target value");
        } else {
            System.out.println(
                    "The indices of the two numbers that add up to the target value are: " + ans[0] + " and " + ans[1]);
        }
        sc.close();
    }

}
