package homework9;

public class solution{
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

    
    

}
