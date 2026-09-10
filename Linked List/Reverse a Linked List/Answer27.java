import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Answer27 {

    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous; 
            previous = current; 
            current = temp; 

        }
        return previous;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = null;
        ListNode tail = null;
        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        ListNode reversedHead = reverseLinkedList(head);
        System.out.println("Reversed linked list:");
        printLinkedList(reversedHead);
        sc.close();
    }

}
