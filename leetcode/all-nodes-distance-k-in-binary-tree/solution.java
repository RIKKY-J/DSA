/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> mp;
    List<Integer> num;
    Set<TreeNode> visited;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        mp = new HashMap<>();
        num = new ArrayList<>();
        visited = new HashSet<>();

        bfs(root);
        find(target, k);

        return num;
    }

    public void find(TreeNode target, int k) {
        if (target == null || k < 0 || visited.contains(target)) {
            return;
        }

        visited.add(target);

        if (k == 0) {
            num.add(target.val);
            return;
        }

        find(target.left, k - 1);
        find(target.right, k - 1);
        find(mp.get(target), k - 1);
    }

    public void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp.left != null) {
                q.add(temp.left);
                mp.put(temp.left, temp);
            }

            if (temp.right != null) {
                q.add(temp.right);
                mp.put(temp.right, temp);
            }
        }
    }
}
