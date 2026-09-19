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

public class Answer32 {

    public static ListNode addTwoNumber(ListNode l1 , ListNode l2)
    {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry=0;
        while(l1!=null || l2!=null)
        {
            int value1 = (l1!=null)?l1.val:0;
            int value2 = (l2!=null)?l2.val:0;
            int sum  = value1 + value2 + carry;
            carry = sum/10;
            current.next= new ListNode(sum%10);
            current  = current.next;
            if(l1!=null)
            {
                l1 = l1.next;
            }
            if(l2!=null)
            {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
    public static void printList(ListNode head)
    {
        ListNode current = head;
        while(current!=null)
        {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the first linked list:");
        int n1 = sc.nextInt();
        ListNode head1 = null;
        ListNode tail1 = null;
        System.out.println("Enter the elements of the first linked list:");
        for(int i=0;i<n1;i++)
        {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if(head1==null)
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
        System.out.println("Enter the number of elements in the second linked list:");
        int n2 = sc.nextInt();
        ListNode head2 = null;
        ListNode tail2 = null;
        System.out.println("Enter the elements of the second linked list:");
        for(int i=0;i<n2;i++)
        {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if(head2==null)
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
        ListNode result = addTwoNumber(head1, head2);
        System.out.println("Resultant linked list:");
        printList(result);
        sc.close();
    }
    
}


// Time Complexity: O(max(n, m)) where n and m are the number of nodes in the two linked lists. We traverse both linked lists once to add the numbers represented by them.

// Space Complexity: O(max(n, m)) as we are creating a new linked list to store the result, which takes up space proportional to the maximum number of nodes in the two input linked lists.