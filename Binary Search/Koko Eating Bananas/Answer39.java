import java.util.*;

public class Answer39 {

    public static int getMax(int arr[])
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i<arr.length ; i++)
        {
            max = Math.max(max,arr[i]);
        }
        return max;
    }
    public static int getTimeTake(int arr[],int k)
    {
        int total = 0;
        for(int i = 0 ; i<arr.length ; i++)
        {
            total += Math.ceil((double)arr[i]/k);
        }
        return total;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        int result = high;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int time = getTimeTake(piles, mid);
            if(time<=h)
            {
                result = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return result;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of piles");
        int n = sc.nextInt();
        int[] piles = new int[n];
        System.out.println("Enter the number of bananas in each pile");
        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }
        System.out.println("Enter the number of hours");
        int h = sc.nextInt();

        int result = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
        sc.close();
    }
}
