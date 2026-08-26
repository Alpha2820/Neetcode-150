import java.util.*;

public class Answer14 {
    public static int trappingRainWater(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        int leftMax = arr[left];
        int rightMax = arr[right];
        int result = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, arr[left]);
                result += leftMax - arr[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, arr[right]);
                result += rightMax - arr[right];
            }
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The amount of trapped rainwater is: " + trappingRainWater(arr));
        sc.close();

    }

}

// Time Complexity: O(n) - The while loop runs until the left pointer is less
// than the right pointer, which means it will run at most n times, where n is
// the number of elements in the array. Therefore, the overall time complexity
// is O(n).

// Space Complexity: O(1) - The space used by the algorithm is constant, as we
// are not using any additional data structures that grow with the input size.
// The output variable does not count towards space complexity as it is required
// to store the result.