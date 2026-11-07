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
    public boolean findTarget(TreeNode root, int k) {
    List<Integer> ls = new ArrayList<>();
    inorder(root , ls); 
    HashMap<Integer, Integer> mp = new HashMap<>();
    for(int i = 0 ; i < ls.size() ; i++){
        int com = k - ls.get(i);
        if(mp.containsKey(com)){
            return true;
        }
        mp.put(ls.get(i) , i);
    }
    return false;
    }
   public void inorder(TreeNode root ,List<Integer> ls){
    if(root == null){ return; }
    inorder(root.left , ls);
    ls.add(root.val);
    inorder(root.right , ls);
   }
}