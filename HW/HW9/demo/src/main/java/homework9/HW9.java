package main.java.homework9;

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

