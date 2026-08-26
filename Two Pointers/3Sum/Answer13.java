import java.util.*;

public class Answer13 {

    public static List<List<Integer>> threeSum(int arr[]) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int value = arr[i] + arr[left] + arr[right];
                if (value < 0) {
                    left++;
                } else if (value > 0) {
                    right--;
                } else {
                    ans.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1]) {
                        left++;
                    }

                }
            }
        }
        return ans;
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
        List<List<Integer>> ans = threeSum(arr);
        if (ans.isEmpty()) {
            System.out.println("No triplets found that add up to zero");
        } else {
            System.out.println("The triplets that add up to zero are:");
            for (List<Integer> triplet : ans) {
                System.out.println(triplet);
            }
        }
        sc.close();
    }
}
// Time Complexity: O(n^2) - The outer loop runs n times, and for each
// iteration, the inner while loop can run up to n times in the worst case.
// Therefore, the overall time complexity is O(n^2).

// Space Complexity: O(1) - The space used by the algorithm is constant, as we
// are not using any additional data structures that grow with the input size.
// The output list does not count towards space complexity as it is required to
// store the results.
