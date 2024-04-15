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
     public static TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
        
    }
    public static void main (String[]args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Starting Tree(level order traversal):" + root.val + " " + root.left.val + " " + root.right.val + " " + root.left.left.val
         + " " + root.left.right.val + " " + root.right.left.val + " " + root.right.right.val);

        invertTree(root);
        System.out.println("Inverted Tree(level order traversal):" + root.val + " " + root.left.val + " " + root.right.val + " " + root.left.left.val
         + " " + root.left.right.val + " " + root.right.left.val + " " + root.right.right.val);

        // Test case 2 (root is null)
         TreeNode rootNull = null;
         invertTree(rootNull);
         System.out.println("Inverted Tree (corner case): root is null");

    }

  }