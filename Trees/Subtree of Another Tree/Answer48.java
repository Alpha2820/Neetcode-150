import java.util.*;

class TreeNode{
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

public class Answer48 {

    public static  boolean isSameTree(TreeNode p , TreeNode q)
    {
        if((p==null && q==null))
        {
            return true;
        }
        if((p!=null && q!=null) && (p.val == q.val))
        {
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
        return false;
    }

    public static boolean isSubTree(TreeNode root, TreeNode subRoot)
    {
        if(root == null)
        {
            return false;
        }
        if(subRoot == null)
        {
            return true;
        }
        if(isSameTree(root,subRoot))
        {
            return true;
        }
        return isSubTree(root.left,subRoot) || isSubTree(root.right,subRoot);
    }
    public static void printTree(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val+" ");
        printTree(root.left);
        printTree(root.right);
    }
    public static TreeNode insertNode(TreeNode root,int val)
    {
        if(root == null)
        {
            return new TreeNode(val);
        }
        if(val<root.val)
        {
            root.left = insertNode(root.left,val);
        }
        else
        {
            root.right = insertNode(root.right,val);
        }
        return root;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes in the main tree:");
        int n = sc.nextInt();
        TreeNode root = null;
        System.out.println("Enter the values of the nodes in the main tree:");
        for(int i=0;i<n;i++)
        {
            int val = sc.nextInt();
            root = insertNode(root,val);
        }
        System.out.println("Enter the number of nodes in the subtree:");
        int m = sc.nextInt();
        TreeNode subRoot = null;
        System.out.println("Enter the values of the nodes in the subtree:");
        for(int i=0;i<m;i++)
        {
            int val = sc.nextInt();
            subRoot = insertNode(subRoot,val);
        }
        if(isSubTree(root,subRoot))
        {
            System.out.println("The subtree is present in the main tree.");
        }
        else
        {
            System.out.println("The subtree is not present in the main tree.");
        }
        sc.close();
    }
}
