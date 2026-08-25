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
