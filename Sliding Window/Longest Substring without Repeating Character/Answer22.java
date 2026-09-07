import java.util.*;

public class Answer22 {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.nextLine();
        int result = lengthOfLongestSubstring(s);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
        sc.close();
    }
}

// Time Complexity: O(n) where n is the length of the string s. We are traversing the string s once.
// Space Complexity: O(min(n, m)) where n is the length of the string s and m is the size of the character set (which is 128 for ASCII). In the worst case, we may have to store all characters in the set.