import java.util.*;

public class Answer37{

    public static int binary(int arr[],int key)
    {
        int low = 0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]==key)
            {
                return mid;
            }
            else if(arr[mid]>key)
            {
                high--;
            }
            else
            {
                low++;
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element to be searched");
        int key = sc.nextInt();
        int result = binary(arr, key);
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