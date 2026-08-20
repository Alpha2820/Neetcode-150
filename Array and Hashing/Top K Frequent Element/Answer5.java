import java.util.*;

public class Answer5 {
    public static int[] topKfrequent(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int result[] = new int[pq.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        System.out.println("Enter the elements of the array");
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k");
        int k = sc.nextInt();
        System.out.println("Input array is: " + Arrays.toString(arr));
        int result[] = topKfrequent(arr, k);
        System.out.println("The top " + k + " frequent elements are:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        sc.close();
    }

}
// Time Complexity: O(n log k) - We traverse the array once to build the
// frequency map, which takes O(n) time. Then we add each unique element to the
// priority queue, which takes O(log k) time for each element. Since we only
// keep k elements in the priority queue, the overall time complexity is O(n log
// k).

// Space Complexity: O(n) - We use a HashMap to store the frequency of each
// unique element, which takes up additional space proportional to the number of
// unique elements in the array. The priority queue also takes up space
// proportional to k, but since k is typically much smaller than n, we can
// consider the overall space complexity to be O(n).