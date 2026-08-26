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

// Time Complexity: O(n) - The while loop runs until the left pointer is less
// than or equal to the right pointer, which means it will run at most n/2
// times, where n is the number of characters in the string. Therefore, the
// overall time complexity is O(n).

// Space Complexity: O(1) - The space used by the algorithm is constant, as we
// are not using any additional data structures that grow with the input size.
// The output variable does not count towards space complexity as it is required
// to store the result.