import java.util.*;

public class Answer4 {
    public static List<List<String>> anagramsGroup(String arr[]) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : arr) {
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array");
        int size = sc.nextInt();
        String arr[] = new String[size];
        System.out.println("Enter the elements of the Array");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.next();
        }
        List<List<String>> ans = anagramsGroup(arr);
        System.out.println("The Anagrams Groups are : ");
        for (List<String> group : ans) {
            System.out.println(group);
        }
        sc.close();

    }

}

// Time Complexity: O(n * k log k) - We traverse the array of strings once,
// where n is the number of strings and k is the maximum length of a string. For
// each string, we sort its characters, which takes O(k log k) time. Therefore,
// the overall time complexity is O(n * k log k).

// Space Complexity: O(n * k) - We use a HashMap to store the groups of
// anagrams, where n is the number of strings and k is the maximum length of a
// string. The keys in the HashMap are the sorted strings, which can take up to
// O(k) space each. The values in the HashMap are lists of strings, which can
// also take up to O(k) space each. Therefore, the overall space complexity is
// O(n * k).