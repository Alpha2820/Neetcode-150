import java.util.*;

public class Answer7 {

    public static int[] productOfArrayExceptSelf(int nums[]) {
        int prefix = 1;
        int output[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] = output[i] * postfix;
            postfix *= nums[i];
        }
        return output;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array");
        int size = sc.nextInt();
        System.out.println("Enter the Elements in the Array");
        int nums[] = new int[size];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int output[] = productOfArrayExceptSelf(nums);
        System.out.println("Output: " + Arrays.toString(output));
        sc.close();
    }
}
