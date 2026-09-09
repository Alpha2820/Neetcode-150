import java.util.*;

public class Answer26 {
    public static int[] maxSlidingWindow(int arr[],int k)
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int result[] = new int[arr.length-k+1];
        for(int i=0;i<k;i++)
        {
            pq.add(arr[i]);
        }
        result[0]=pq.peek();
        for(int i=k;i<arr.length;i++)
        {
            pq.remove(arr[i-k]);
            pq.add(arr[i]);
            result[i-k+1]=pq.peek();
        }
        return result;
    }
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the size of the window");
        int k=sc.nextInt();
        System.out.println("The maximum elements in each window are:");
        int result[] = maxSlidingWindow(arr, k);
        for(int i=0;i<result.length;i++)
        {
            System.out.print(result[i]+" ");
        }
        System.out.println();
        sc.close();
    }
    
}

// Time Complexity : O(n log k) - We traverse the array once, and for each element, we perform insertion and deletion operations on the priority queue, which takes O(log k) time. Therefore, the overall time complexity is O(n log k).

// Space Complexity : O(k) - We use a priority queue to store the elements of the current window, which takes up additional space proportional to the size of the window (k).