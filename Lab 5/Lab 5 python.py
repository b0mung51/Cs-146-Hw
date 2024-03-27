class TreeNode(object):
    values = []

    def __init__(self, val=0, left=None, right=None):

        self.val = val

        self.left = left

        self.right = right
        
    
    
    def inOrderTraversal(node):
        if node is None: return
        TreeNode.values.clear()
        TreeNode.inOrderTraversal(node.left)
        TreeNode.values.append(node.val)
        TreeNode.inOrderTraversal(node.right)

    
    def isValidBST(values):
        for i in range(1,len(values)):
            if values[i-1] >= values[i]:
                return False
        return True

if __name__ == "__main__":
    # Test 1
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(8)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(6)
    print("Tree(level order traversal):", root.val, root.left.val, root.right.val, root.left.left.val,
          root.left.right.val, root.right.left.val, root.right.right.val)

    TreeNode.inOrderTraversal(root)
    answer = TreeNode.isValidBST(TreeNode.values)
    print("isValidBST:", answer)

    # Test 2
    root2 = TreeNode(4)
    root2.left = TreeNode(3)
    root2.right = TreeNode(8)
    root2.left.left = TreeNode(1)
    root2.left.right = TreeNode(5)
    root2.right.left = TreeNode(9)
    print("Tree(level order traversal):", root2.val, root2.left.val, root2.right.val, root2.left.left.val,
          root2.left.right.val, root2.right.left.val)

    TreeNode.inOrderTraversal(root2)
    answer = TreeNode.isValidBST(TreeNode.values)
    print("isValidBST:", answer)

    # Test 3: Single Node
    root_single = TreeNode(5)
    print("Tree(level order traversal):", root_single.val)
    TreeNode.inOrderTraversal(root_single)
    answer_single = TreeNode.isValidBST(TreeNode.values)
    print("isValidBST:", answer_single)

    
