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

// Time Complexity: O(n) - The while loop runs until the left pointer is less
// than or equal to the right pointer, which means it will run at most n times,
// where n is the number of elements in the array. Therefore, the overall time
// complexity is O(n).

// Space Complexity: O(1) - The space used by the algorithm is constant, as we
// are not using any additional data structures that grow with the input size.
// The output array does not count towards space complexity as it is required to
// store the result.