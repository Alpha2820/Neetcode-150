import java.util.*;
public class Answer40{

    public static int findMin(int nums[])
    {
        int left = 0;
        int right = nums.length-1;
        while(left<-right)
        {
            int mid = left = (right-left)/2;
            if(nums[mid]<nums[right])
            {
                right = mid;
            }
            else
            {
                left = mid+1;
            }
        }
        return nums[left];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = findMin(arr);
        System.out.println("Minimum element in the rotated sorted array: " + min);
        sc.close();
    }
}