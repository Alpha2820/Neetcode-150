import java.util.*;

public class Answer12 {
    public static int maxWater(int arr[]) {
        int left = 0;
        int right = arr.length - 1;
        int area = 0;
        while (left < right) {
            int maxArea = Math.min(arr[left], arr[right]) * (right - left);
            area = Math.max(area, maxArea);
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Input array is: " + Arrays.toString(arr));
        int result = maxWater(arr);
        System.out.println("The maximum water that can be contained is: " + result);
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