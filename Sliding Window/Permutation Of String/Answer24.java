import java.util.*;

public class Answer24 {
    public static boolean permutationOFString(String s, String p)
    {
        if(s.length()>p.length())
        {
            return false;
        }
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i = 0 ; i<s.length() ; i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int i = 0 ;
        int reqMatch = map.size();
        int countMatch = 0;
        while(i<p.length())
        {
            char ch = p.charAt(i);
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)
                {
                    countMatch++;
                }
            }
            i++;
        }
        if(countMatch==reqMatch)
        {
            return true;
        }
        while(i<p.length())
        {
            char ch = p.charAt(i);
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)
                {
                    countMatch++;
                }
            }
            char ch2 = p.charAt(i-s.length());
            if(map.containsKey(ch2))
            {
                map.put(ch2,map.get(ch2)+1);
                if(map.get(ch2)==1)
                {
                    countMatch--;
                }
            }
            i++;
        }
        return countMatch==reqMatch;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.nextLine();
        System.out.println("Enter the pattern");
        String p = sc.nextLine();
        boolean ans = permutationOFString(s,p);
        if(ans)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
        sc.close();
    }
}

// Time Complexity: O(n) where n is the length of the string p. We are traversing the string p once.
// Space Complexity: O(1) as the HashMap will have at most 26 characters (for lowercase letters).
