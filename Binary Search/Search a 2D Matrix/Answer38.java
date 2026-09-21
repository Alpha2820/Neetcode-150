import java.util.*;

public class Answer38 {

    public static boolean searchMatrix(int arr[][], int key) {
        int rows = arr.length;
        int cols = arr[0].length;

        int low = 0;
        int high = (rows * cols) - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > arr[mid / cols][mid % cols]) {
                low = mid + 1;
            } else if (mid < arr[mid / cols][mid % cols]) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        int n = sc.nextInt();
        int matrix[][] = new int[m][n];
        System.out.println("Enter the elements of the matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the key to search: ");
        int key = sc.nextInt();
        boolean ans = searchMatrix(matrix, key);
        if (ans) {
            System.out.println("The key " + key + " is present in the matrix.");
        } else {
            System.out.println("The key " + key + " is not present in the matrix.");
        }
        sc.close();
    }

}
