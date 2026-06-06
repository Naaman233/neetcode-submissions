/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.offer(root);
        }

        int index = 0;
        while (!q.isEmpty()) {

            int n = q.size();
            List<Integer> st = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                TreeNode current = q.poll();
                st.add(current.val);

                if (current.left != null){
                    q.offer(current.left);
                }

                if (current.right != null){
                    q.offer(current.right);
                }
            }
            res.add(index, st);
            index++;
        }
        return res;
    }
}
