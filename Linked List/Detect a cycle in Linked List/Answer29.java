import java.util.*;

class ListNode{
    int val;
    ListNode next;;
    public ListNode(int val)
    {
        this.val = val;
        this.next = null;
    }
}

public class Answer29{


    public static boolean hasCycle(ListNode head)
    {
        ListNode slow = head;
        ListNode  fast = head;
        while((fast!=null)&&(fast.next!=null))
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the linked list:");
        int n = sc.nextInt();
        ListNode head = null;
        ListNode tail = null;
        for(int i=0;i<n;i++)
        {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if(head==null)
            {
                head = newNode;
                tail = newNode;
            }
            else
            {
                tail.next = newNode;
                tail = newNode;
            }
        }
        System.out.println("Enter the position where the cycle should be created (0 for no cycle):");
        int pos = sc.nextInt();
        if(pos>0)
        {
            ListNode cycleNode = head;
            for(int i=1;i<pos;i++)
            {
                cycleNode = cycleNode.next;
            }
            tail.next = cycleNode;
        }
        System.out.println("Cycle detected: " + hasCycle(head));
        sc.close();
    }
}