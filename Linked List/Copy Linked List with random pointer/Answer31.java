import java.util.*;
class ListNode{
    int val;
    ListNode next;
    ListNode random;

    public ListNode(int val)
    {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Answer31{
    public static ListNode copyOfLinekdList(ListNode head)
    {
        ListNode current = head;
        HashMap<ListNode,ListNode>map = new HashMap<>();
        while(current!=null)
        {
            ListNode copy = new ListNode(current.val);
            map.put(current,copy);
            current = current.next;
        }
        current = head;
        while(current!=null)
        {
            ListNode copy = map.get(current);
            copy.next = map.get(current.next);
            copy.random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the linked list:");
        int n = sc.nextInt();
        ListNode head = null;
        ListNode tail = null;
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the value of node "+(i+1)+":");
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
        System.out.println("Enter the random pointer for each node (enter -1 for null):");
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the random pointer for node "+(i+1)+":");
            int randomIndex = sc.nextInt();
            if(randomIndex!=-1)
            {
                ListNode current = head;
                for(int j=0;j<randomIndex;j++)
                {
                    current = current.next;
                }
                ListNode temp = head;
                for(int j=0;j<i;j++)
                {
                    temp = temp.next;
                }
                temp.random = current;
            }
        }
        ListNode copiedList = copyOfLinekdList(head);
        System.out.println("Original Linked List:");
        ListNode current = head;
        while(current!=null)
        {
            System.out.print("Node value: "+current.val);
            if(current.random!=null)
            {
                System.out.print(", Random pointer value: "+current.random.val);
            }
            else
            {
                System.out.print(", Random pointer value: null");
            }
            System.out.println();
            current = current.next;
        }
        System.out.println("Copied Linked List:");
        current = copiedList;
        while(current!=null)
        {
            System.out.print("Node value: "+current.val);
            if(current.random!=null)
            {
                System.out.print(", Random pointer value: "+current.random.val);
            }
            else
            {
                System.out.print(", Random pointer value: null");
            }
            System.out.println();
            current = current.next;
        }
        sc.close();
    }
}