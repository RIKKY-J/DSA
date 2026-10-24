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

    public int height(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null) return 1;

        return 1 + height(root.left);
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // CASE 1:
        // Left and right heights are equal.
        // Therefore, the left subtree is perfect.
        if (leftHeight == rightHeight) {

            int leftSubTreeNodes =
                    (int) Math.pow(2, leftHeight) - 1;

            int parentNode = 1;

            // Right subtree may or may not be perfect.
            int rightSubTreeNodes =
                    countNodes(root.right);

            return leftSubTreeNodes
                    + parentNode
                    + rightSubTreeNodes;

        } else {

            // CASE 2:
            // Left height is greater.
            // Therefore, the right subtree is perfect.

            int leftSubTreeNodes =
                    countNodes(root.left);

            int parentNode = 1;

            int rightSubTreeNodes =
                    (int) Math.pow(2, leftHeight - 1) - 1;

            return leftSubTreeNodes
                    + parentNode
                    + rightSubTreeNodes;
        }
    }
}