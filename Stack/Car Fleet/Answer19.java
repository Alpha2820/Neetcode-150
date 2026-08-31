import java.util.*;

public class Answer19 {
    public static int carFleet(int target, int position[], int speed[]) {
        int arr[][] = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> result = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i][0];
            int valueSpeed = arr[i][1];
            double time = (double) (target - value) / valueSpeed;
            result.push(time);
            if (result.size() >= 2 && result.peek() <= result.get(result.size() - 2)) {
                result.pop();
            }
        }
        return result.size();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of cars in the fleet:");
        int n = sc.nextInt();
        int[] positions = new int[n];
        System.out.println("Enter the positions of the cars:");
        for (int i = 0; i < n; i++) {
            positions[i] = sc.nextInt();
        }
        System.out.println("Enter the speeds of the cars:");
        int[] speeds = new int[n];
        for (int i = 0; i < n; i++) {
            speeds[i] = sc.nextInt();
        }
        System.out.println("Enter the target position:");
        int target = sc.nextInt();
        int fleets = carFleet(target, positions, speeds);
        System.out.println("Number of car fleets that will arrive at the destination: " + fleets);
        sc.close();
    }
}
