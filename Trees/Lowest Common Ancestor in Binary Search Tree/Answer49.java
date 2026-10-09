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

public class Answer49 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p , TreeNode q)
    {
        if(root==null || p == null || q == null)
        {
            return null;
        }
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        if(max<root.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(min>root.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        else
        {
            return root;
        }
    }
    public static void main(String args[])
    {
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
                val = sc.nextInt();
                if (val != -1) {
                    current.right = new TreeNode(val);
                    queue.add(current.right);
                }
            }
        }

        System.out.println("Enter the values of the two nodes to find their lowest common ancestor:");
        int pVal = sc.nextInt();
        int qVal = sc.nextInt();

        TreeNode lca = lowestCommonAncestor(root, new TreeNode(pVal), new TreeNode(qVal));
        if (lca != null) {
            System.out.println("The lowest common ancestor of " + pVal + " and " + qVal + " is: " + lca.val);
        } else {
            System.out.println("Lowest common ancestor not found.");
        }
        sc.close();
    }
    
}
