import java.util.*;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Answer35 {

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return dummy.next;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of linked lists:");
        int k = sc.nextInt();
        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            System.out.println("Enter the number of elements in linked list " + (i + 1) + ":");
            int n = sc.nextInt();
            ListNode head = null;
            ListNode tail = null;
            System.out.println("Enter the elements of linked list " + (i + 1) + ":");
            for (int j = 0; j < n; j++) {
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
            lists[i] = head;
        }
        for (int i = 1; i < k; i++) {
            lists[i] = merge(lists[i - 1], lists[i]);
        }
        System.out.println("Merged linked list:");
        ListNode mergedHead = lists[k - 1];
        while (mergedHead != null) {
            System.out.print(mergedHead.val + " ");
            mergedHead = mergedHead.next;
        }
        System.out.println();
        sc.close();
    }
}


// Time Complexity: O(N log k) where N is the total number of nodes in all linked lists and k is the number of linked lists. We merge k sorted linked lists using a divide and conquer approach, which takes log k merges, and each merge operation takes O(N) time.

// Space Complexity: O(1) as we are using constant space for pointers and variables, and not using any additional data structures that grow with input size.