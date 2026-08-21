import java.util.*;

public class Answer10 {
    public static boolean validPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.nextLine();
        boolean ans = validPalindrome(str);
        if (ans) {
            System.out.println("The string is a valid palindrome");
        } else {
            System.out.println("The string is not a valid palindrome");
        }
        sc.close();
    }
}
