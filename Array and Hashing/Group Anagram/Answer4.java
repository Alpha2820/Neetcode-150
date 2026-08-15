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
