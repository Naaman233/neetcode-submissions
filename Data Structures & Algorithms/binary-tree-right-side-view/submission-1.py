# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        result = []
        if root is None:
            return result
        
        q = deque()
        q.append(root)

        while q:
            size = len(q)
            for i in range(size):
                current = q.popleft()

                if i == size - 1:
                    result.append(current.val)
                
                if current.left:
                    q.append(current.left)
                if current.right:
                    q.append(current.right)
        
        return result

                


        