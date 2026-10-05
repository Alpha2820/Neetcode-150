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

public class Answer46 {
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the tree:");
        int n = sc.nextInt();
        System.out.println("Enter the values of the nodes in level order (use -1 for null nodes):");
        TreeNode root = null;
        if (n > 0) {
            Queue<TreeNode> queue = new LinkedList<>();
            int val = sc.nextInt();
            root = new TreeNode(val);
            queue.add(root);
            for (int i = 1; i < n; i++) {
                TreeNode current = queue.poll();
                val = sc.nextInt();
                if (val != -1) {
                    current.left = new TreeNode(val);
                    queue.add(current.left);
                }
                if (i + 1 < n) {
                    val = sc.nextInt();
                    if (val != -1) {
                        current.right = new TreeNode(val);
                        queue.add(current.right);
                    }
                    i++;
                }
            }
        }
        boolean balanced = isBalanced(root);
        if (balanced) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
        sc.close();
    }
}

// Time Complexity : O(n) where n is the number of nodes in the binary tree. We visit each node once to calculate the height and check if the tree is balanced.

// Space Complexity : O(h) where h is the height of the binary tree. This space is used by the recursion stack during the traversal of the tree. In the worst case, the height of the tree can be equal to the number of nodes in the tree (for a skewed tree), leading to a space complexity of O(n).