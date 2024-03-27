class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):

         self.val = val

         self.left = left

         self.right = right

    
    def invertTree(root):
        if root is None: return root
        root.left, root.right = TreeNode.invertTree(root.right), TreeNode.invertTree(root.left)

        return root

    def __str__(self):
        return str(self.val)

if __name__ == "__main__":
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(8)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(6)
    print("Starting Tree(Level Order Traversal):",  root.val,
    root.left.val, root.right.val, root.left.left.val, root.left.right.val, 
    root.right.left.val, root.right.right.val)

    TreeNode.invertTree(root)
    print("Starting Tree(Level Order Traversal):",  root.val,
    root.left.val, root.right.val, root.left.left.val, root.left.right.val, 
    root.right.left.val, root.right.right.val )

    #Test case 2 (invert 1 node tree with null value)
    root2 = None
    TreeNode.invertTree(root2)
    print("Null Tree:", root2)

    
