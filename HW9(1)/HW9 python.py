class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    @staticmethod
    def lowestCommonAncestor(node, p, q):
        if not node:
            return None

        if p.val > node.val and q.val > node.val:
            return TreeNode.lowestCommonAncestor(node.right, p, q)
        elif p.val < node.val and q.val < node.val:
            return TreeNode.lowestCommonAncestor(node.left, p, q)
        else:
            return node

if __name__ == "__main__":
    # Test case 1
    root = TreeNode(4)
    root.left = TreeNode(3)
    root.left.left = TreeNode(1)
    root.right = TreeNode(8)
    root.right.right = TreeNode(9)
    root.right.left = TreeNode(5)
    
    p = TreeNode(5)
    q = TreeNode(1)

    answer = TreeNode.lowestCommonAncestor(root, p, q)
    print("Given Tree(Level Order Traversal): 4 3 8 1 5 9, the lowest common ancestor for 1 and 5 are", answer.val)

    # Test case 2 (only 2 nodes and when the ancestor is the root)
    p2 = TreeNode(5)
    q2 = TreeNode(9)
    answer2 = TreeNode.lowestCommonAncestor(p2, p2, q2)
    print("Lowest Common Ancestor of", p2.val, "and", q2.val, "is:", answer2.val)
