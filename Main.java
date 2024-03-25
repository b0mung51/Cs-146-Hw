package homework9;


public class Main extends solution{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(5);
        
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(1);

        TreeNode answer = lowestCommonAncestor(root,p,q);
        System.out.println(answer.val);
    }
}
