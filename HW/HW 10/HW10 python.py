from typing import List, Optional
import queue

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def levelOrder(self, root: Optional['TreeNode']) -> List[List[int]]:
        result = []
        if root is None:
            return result

        q = queue.Queue()
        q.put(root)

        while not q.empty():
            level_size = q.qsize()
            level_nodes = []

            for _ in range(level_size):
                node = q.get()
                level_nodes.append(node.val)

                if node.left:
                    q.put(node.left)
                if node.right:
                    q.put(node.right)

            result.append(level_nodes)

        return result

# Testing
root = TreeNode(4)
root.left = TreeNode(3)
root.right = TreeNode(8)
root.left.left = TreeNode(1)
root.right.left = TreeNode(5)
root.right.right = TreeNode(9)

# Test case 1: Normal BST printed in Level order
print("Test case 1: Normal BST print Level order:")
answer = root.levelOrder(root)
for level in answer:
    for val in level:
        print(val, end=" ")
    print()

# Test case 2: null root, one node
print("Test case 2: Null")
root2 = None
answer2 = root.levelOrder(root2)
for level in answer2:
    for val in level:
        print(val, end=" ")
    print()
