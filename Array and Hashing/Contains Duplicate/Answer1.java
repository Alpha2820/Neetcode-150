import java.util.*;

public class Answer1 {

    public static boolean containsDuplicate(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        if (containsDuplicate(arr)) {
            System.out.println("The array contains duplicate elements");
        } else {
            System.out.println("The array does not contain duplicate elements");
        }
        sc.close();
    }
}