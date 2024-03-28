import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

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


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); //offer adds to queue if possible
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for(int i = 0;i<levelSize;i++){
                TreeNode node = queue.poll(); //poll removes head and returns null if empty queue
                levelNodes.add(node.val);

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            result.add(levelNodes);
        }
        return result;
    }

    public static void main(String arg[]){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        //Test case 1
        System.out.println("Test case 1: Normal BST print Level order:");
        List<List<Integer>> answer = levelOrder(root);
        for(List<Integer> level:answer){
            
            for(int val:level){
                System.out.print(val);
            }
            System.out.println();
        }
        //Test case 2: null root, one node
        System.out.println("Test case 2: Null");
        TreeNode root2 = null;
        List<List<Integer>> answer2 = levelOrder(root2);
        for(List<Integer> level:answer2){
            
            for(int val:level){
                System.out.print(val);
            }
            System.out.println();
        }
    }

}