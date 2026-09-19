import java.util.*;
public class Answer33 {

    public static int findDuplicate(int nums[])
    {
        for(int i = 0 ; i<nums.length ; i++)
        {
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0)
            {
                return Math.abs(nums[i]);
            }
            nums[index] *= -1;
        }
        return -1;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int duplicate = findDuplicate(arr);
        if(duplicate!=-1)
        {
            System.out.println("The duplicate number is: " + duplicate);
        }
        else
        {
            System.out.println("No duplicate number found.");
        }
        sc.close();
    }
}


// Time Complexity: O(n) where n is the number of elements in the array. We traverse the entire array once to find the duplicate number.

// Space Complexity: O(1) as we are using constant space for variables and not using any additional data structures that grow with input size.