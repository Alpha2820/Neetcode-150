import java.util.*;

public class Answer3 {
    public static int[] twoSum(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = target - arr[i];
            if (map.containsKey(value)) {
                return new int[] { i, map.get(value) };
            }
            map.put(arr[i], i);
        }
        return new int[] { -1, -1 };
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
        System.out.println("Enter the target value");
        int target = sc.nextInt();
        int ans[] = twoSum(arr, target);
        if (ans[0] == -1 && ans[1] == -1) {
            System.out.println("No such pair exists");
        } else {
            System.out.println("The indices of the two numbers are : " + ans[0] + " and " + ans[1]);
        }
        sc.close();
    }
}

// Time Complexity: O(n) - We traverse the array once, and each operation inside
// the loop is O(1) due to the HashMap operations.
// Space Complexity: O(n) - We use a HashMap to store the elements of the array,
// which takes up additional space proportional to the number of unique elements
// in the array.