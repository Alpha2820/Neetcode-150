import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val)
    {
      this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Answer44 {

    public static TreeNode invertTree(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.right = invertTree(root.left);
        node.left = invertTree(root.right);
        return node;
    }
    public static void printTree(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the binary tree");
        int n = sc.nextInt();
        System.out.println("Enter the values of the nodes");
        TreeNode[] nodes = new TreeNode[n];
        for(int i=0;i<n;i++)
        {
            int val = sc.nextInt();
            nodes[i] = new TreeNode(val);
        }
        TreeNode root = nodes[0];
        for(int i=0;i<n;i++)
        {
            int leftIndex = 2*i + 1;
            int rightIndex = 2*i + 2;
            if(leftIndex<n)
            {
                nodes[i].left = nodes[leftIndex];
            }
            if(rightIndex<n)
            {
                nodes[i].right = nodes[rightIndex];
            }
        }
        TreeNode invertedRoot = invertTree(root);
        System.out.println("Inverted binary tree:");
        printTree(invertedRoot);
        sc.close();
    }
}


// Time Complexity : O(n) where n is the number of nodes in the binary tree. We visit each node once to invert the tree.

// Space Complexity : O(h) where h is the height of the binary tree. This space is used by the recursion stack during the inversion of the tree. In the worst case, the height of the tree can be equal to the number of nodes in the tree (for a skewed tree), leading to a space complexity of O(n).