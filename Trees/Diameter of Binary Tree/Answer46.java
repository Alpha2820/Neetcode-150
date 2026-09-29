import java.util.*;


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode()
    {

    }
    TreeNode(int val)
    {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Answer46 {

    public static int dfs(TreeNode root, int arr[])
    {
        if(root==null)
        {
            return 0;
        }
        int left = dfs(root.left,arr);
        int right = dfs(root.right,arr);
        arr[0] = Math.max(arr[0],left+right);
        return 1 + Math.max(left,right);
    }

    public static int diameterofBinaryTree(TreeNode root)
    {
        int result[] = new int[1];
        dfs(root,result);
        return result[0];
    }

    public static void printTree(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        System.out.print(root.val+" ");
        printTree(root.left);
        printTree(root.right);
    }
    public static TreeNode insertIntoTree(TreeNode root, int val)
    {
        if(root==null)
        {
            return new TreeNode(val);
        }
        if(val<root.val)
        {
            root.left = insertIntoTree(root.left,val);
        }
        else
        {
            root.right = insertIntoTree(root.right,val);
        }
        return root;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the tree");
        int n = sc.nextInt();
        TreeNode root = null;
        System.out.println("Enter the elements in the tree");
        for(int i=0;i<n;i++)
        {
            int val = sc.nextInt();
            root = insertIntoTree(root,val);
        }
        System.out.println("The elements in the tree are");
        printTree(root);
        int diameter = diameterofBinaryTree(root);
        System.out.println("\nThe diameter of the tree is "+diameter);
        sc.close();
    }
}
