import java.util.*;

public class Answer9{

    public static int logenstCommonSubsequence(int arr[])
    {
        HashSet<Integer>set = new HashSet<>();
        for(int i = 0 ; i<nums.length ; i++)
        {
            set.add(nums[i]);
        }
        int maxStreak = 0;
        for(int j = 0 ; j<nums.length ; j++)
        {
            if(set.contains(nums[j]-1))
            {
                int currNum = arr[j];
                int currStreak = 1;
                while(set.contains(currNum+1))
                {
                    currNum++;
                    currStreak++;
                }
                maxStreak = Math.max(maxStreak,currStreak);
            }
        }
        return maxStreak;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int ans = logenstCommonSubsequence(arr);
        System.out.println("The longest consecutive sequence is: "+ans);
        sc.close();
    }
}
