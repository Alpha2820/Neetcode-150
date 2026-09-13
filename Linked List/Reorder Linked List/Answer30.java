import java.util.*;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Answer30 {

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left > right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the linked list");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the linked list");
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;
        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }
        reorderList(head);
        System.out.println("The reordered linked list is:");
        temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        sc.close();
    }
}
