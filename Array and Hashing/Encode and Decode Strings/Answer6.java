import java.util.*;

public class Answer6 {
    public static String encode(List<String> str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.size(); i++) {
            String key = str.get(i);
            sb.append(key.length()).append("#").append(key);
        }
        return sb.toString();

    }

    public static List<String> decode(String str) {
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            result.add(str.substring(i, i + length));
            i = i + length;
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array");
        int size = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Elements in the Array");
        ArrayList<String> str = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            str.add(sc.nextLine());
        }
        String encoded = encode(str);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);
        sc.close();

    }
}

// Time Complexity: O(n) - We traverse the list of strings once to encode them,
// and we traverse the encoded string once to decode it. Each operation inside
// the loops is O(1).

// Space Complexity: O(n) - We use a StringBuilder to build the encoded string,
// which takes up additional space proportional to the total length of the
// strings in the list. The decoded list also takes up additional space
// proportional to the number of strings in the original list.