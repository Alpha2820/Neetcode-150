import java.util.*;

class ListNode{
    int val;
    ListNode next;
    
    ListNode(int val)
    {
        this.val = val;
        this.next = null;
    }
}

public class Answer28 {

    public static ListNode mergeLinkedList(ListNode head1 , ListNode head2)
    {
        if(head1 == null)
        {
            return head2;
        }
        if(head2 == null)
        {
            return head1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while((head1!=null)&&(head2!=null))
        {
            if(head1.val<=head2.val)
            {
                current.next = head1;
                head1 = head1.next;
            }
            else
            {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        if(head1!=null)
        {
            current.next = head1;
        }
        if(head2!=null)
        {
            current.next = head2;
        }
        return dummy.next;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the first sorted linked list:");
        int n1 = sc.nextInt();
        ListNode head1 = null;
        ListNode tail1 = null;
        System.out.println("Enter the elements of the first sorted linked list:");
        for(int i=0; i<n1; i++)
        {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if(head1 == null)
            {
                head1 = newNode;
                tail1 = newNode;
            }
            else
            {
                tail1.next = newNode;
                tail1 = newNode;
            }
        }
        System.out.println("Enter the number of elements in the second sorted linked list:");
        int n2 = sc.nextInt();
        ListNode head2 = null;
        ListNode tail2 = null;
        System.out.println("Enter the elements of the second sorted linked list:");
        for(int i=0; i<n2; i++)
        {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if(head2 == null)
            {
                head2 = newNode;
                tail2 = newNode;
            }
            else
            {
                tail2.next = newNode;
                tail2 = newNode;
            }
        }
        ListNode mergedHead = mergeLinkedList(head1, head2);
        System.out.println("Merged sorted linked list:");
        while(mergedHead != null)
        {
            System.out.print(mergedHead.val + " ");
            mergedHead = mergedHead.next;
        }
        sc.close();
    }
}


// Time Complexity: O(n + m) where n is the number of nodes in the first linked list and m is the number of nodes in the second linked list. We traverse both linked lists once to merge them into a single sorted linked list.

// Space Complexity: O(1) as we are using constant space for pointers and variables, and not using any additional data structures that grow with input size.