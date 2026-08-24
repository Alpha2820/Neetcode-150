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
