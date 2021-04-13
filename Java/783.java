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
class Problem783 {
    int ans = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root ==null)return;
        dfs(root.left);
        if(pre!=null){
            ans = Math.min(ans, Math.abs(pre.val-root.val));
        }
        pre = root;
        dfs(root.right);
    }
}
