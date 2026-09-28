import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Answer45 {


    public static int maxDepth(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left,right);
    }
    public static void printTree(TreeNode root)
    {
        if(root == null)
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
        int depth = maxDepth(root);
        System.out.println("Maximum depth of the binary tree: " + depth);
        sc.close();

    }
    
}
