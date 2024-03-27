
public class TreeNode {

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

    public static TreeNode lowestCommonAncestor (TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return null;

        if(p.val>node.val && q.val>node.val){
            return lowestCommonAncestor(node.right,p,q);
        }
        else if(p.val<node.val && q.val<node.val){
            return lowestCommonAncestor(node.left,p,q);
        }
        else{
            return node;
        }
    }

    public static void main(String[] args) {
        //Test case 1
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(5);
        
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        TreeNode answer = lowestCommonAncestor(root,p,q);
        System.out.println("Given Tree(Level Order Traversal): 4 3 8 1 5 9, the lowest common ancestor for 1 and 5 are " +answer.val);

        //Test case 2 (only 2 nodes and when the ancestor is the root)
        TreeNode p2 = new TreeNode(5);
        TreeNode q2 = new TreeNode(9);
        TreeNode answer2 = lowestCommonAncestor(p2, p2, q2);
        System.out.println("Lowest Common Ancestor of " + p2.val + " and " + q2.val + " is: " + answer2.val);
    }
}

