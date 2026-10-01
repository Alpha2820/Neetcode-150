
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Answer47 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static TreeNode insertNode(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else {
            root.right = insertNode(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the first tree:");
        int n1 = sc.nextInt();
        System.out.println("Enter the values of the nodes in the first tree:");
        TreeNode root1 = null;
        for (int i = 0; i < n1; i++) {
            int val = sc.nextInt();
            root1 = insertNode(root1, val);
        }
        System.out.println("Enter the number of nodes in the second tree:");
        int n2 = sc.nextInt();
        System.out.println("Enter the values of the nodes in the second tree:");
        TreeNode root2 = null;
        for (int i = 0; i < n2; i++) {
            int val = sc.nextInt();
            root2 = insertNode(root2, val);
        }
        System.out.println("First tree:");
        printTree(root1);
        System.out.println("\nSecond tree:");
        printTree(root2);
        Answer47 obj = new Answer47();
        boolean result = obj.isSameTree(root1, root2);
        if (result) {
            System.out.println("\nThe two trees are the same.");
        } else {
            System.out.println("\nThe two trees are not the same.");
        }
        sc.close();
    }
}
