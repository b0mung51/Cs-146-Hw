import java.util.ArrayList;

public class TreeNode {

     int val;

     TreeNode left;

     TreeNode right;
     static ArrayList<Integer> values = new ArrayList<Integer>(); // Initialize an ArrayList to store values

     TreeNode() {}

     TreeNode(int val) { this.val = val; }

     TreeNode(int val, TreeNode left, TreeNode right) {

         this.val = val;

         this.left = left;

         this.right = right;

     }
    public static void inOrderTraversal (TreeNode node){
        if(node == null) return;
        values.clear();
        inOrderTraversal(node.left);
        values.add(node.val);
        inOrderTraversal(node.right);

    }
    public static boolean isValidBST(ArrayList<Integer> values) {
        for(int i = 1; i<values.size();i++){
            if(values.get(i-1)>=values.get(i)) return false;
        }
        return true;

    }
    public static void main (String[]args){
        //Test 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree(level order traversal):" + root.val + " " + root.left.val + " " + root.right.val + " " + root.left.left.val
         + " " + root.left.right.val + " " + root.right.left.val + " " + root.right.right.val);

        inOrderTraversal(root);
        boolean answer = isValidBST(values);
        System.out.println("isValidBST:" + answer);
        
        //Test 2
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(9);
        System.out.println("Tree(level order traversal):" + root2.val + " " + root2.left.val + " " + root2.right.val + " " + root2.left.left.val
         + " " + root2.left.right.val + " " + root2.right.left.val);

        inOrderTraversal(root2);
        answer = isValidBST(values);
        System.out.println("isValidBST:" + answer);

        //Test case 3 (single node Tree)
        TreeNode root3 = new TreeNode(5);
        System.out.println("Tree(level order traversal):" + root3.val);
        inOrderTraversal(root3);
        answer = isValidBST(values);
        System.out.println("isValidBST:" + answer);

    }

  }