import java.util.*;


class ListNode{
    int val;
    ListNode next;

    public ListNode(int val)
    {
        this.val = val;
        this.next = null;
    }
}

public class Answer36 {

    public static ListNode reverseKGroups(ListNode head , int k)
    {
        ListNode current = head;
        int count = 0;
        while(current!=null)
        {
            count++;
            current = current.next;
        }
        if(count<k)
        {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        count = 0;
        while((count<k)&&(curr!=null))
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next!=null)
        {
            head.next = reverseKGroups(next, k);
        }
        return prev;
    }


    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the linked list:");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the linked list:");
        ListNode head = null;
        ListNode current = null;

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }
        System.out.println("Enter the value of k:");
        int k = sc.nextInt();
        head = reverseKGroups(head, k);
        ListNode current1 = head;
        System.out.println("Reversed linked list in groups of k:");
        while (current1 != null) {
            System.out.print(current1.val + " ");
            current1 = current1.next;
        }
        System.out.println();
        sc.close();

    }
    
}

// Time Complexity: O(n) where n is the number of nodes in the linked list. We traverse the entire linked list once to count the number of nodes and then again to reverse the nodes in groups of k.

// Space Complexity: O(1) as we are using constant space for pointers and variables, and not using any additional data structures that grow with input size.
