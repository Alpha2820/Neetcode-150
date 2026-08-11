import java.util.*;

public class Answer2 {

    public static boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int j = 0; j < s2.length(); j++) {
            map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j), 0) + 1);
        }
        return map1.equals(map2);

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string");
        String s1 = sc.nextLine();
        System.out.println("Enter the second string");
        String s2 = sc.nextLine();
        if (s1.length() != s2.length()) {
            System.out.println("The strings are not anagrams.");
        }
        if (isAnagram(s1, s2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
        sc.close();
    }
}