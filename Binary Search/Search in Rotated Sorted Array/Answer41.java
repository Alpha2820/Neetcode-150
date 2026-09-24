import java.util.*;

public class Answer41 {

    public static int searchInRotated(int arr[],int target)
    {
        int left = 0;
        int right = arr.length-1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            if(arr[left]<=arr[mid])
            {
                if(arr[left]<=target && target<=arr[mid])
                {
                    right = mid-1;
                }
                else
                {
                    left = mid+1;
                }
            }
            else
            {
                if(arr[mid]<=target && target<=arr[right])
                {
                    left = mid+1;
                }
                else
                {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the target element to search");
        int target = sc.nextInt();
        int result = searchInRotated(arr, target);
        if(result==-1)
        {
            System.out.println("Element not found");
        }
        else
        {
            System.out.println("Element found at index: "+result);
        }
        sc.close();
    } 
}
