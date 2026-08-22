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
