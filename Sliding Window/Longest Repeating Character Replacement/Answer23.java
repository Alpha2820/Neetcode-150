import java.util.*;

public class Answer23 {

    public static int charReplaceMent(String str, int k) {
        int arr[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }
        int i = 0;
        int j = 0;
        int maxCount = 0;
        int maxLength = 0;
        while (j < str.length()) {
            maxCount = Math.max(maxCount, arr[str.charAt(j) - 'A']);
            if ((j - i + 1) - maxCount > k) {
                arr[str.charAt(i) - 'A']--;
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.nextLine();
        System.out.println("Enter the value of k");
        int k = sc.nextInt();
        int result = charReplaceMent(s, k);
        System.out.println(
                "The length of the longest substring after replacing at most " + k + " characters is: " + result);
        sc.close();
    }
}
