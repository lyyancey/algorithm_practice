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
    
    public int count(TreeNode root, int sum){
        if(root==null)return 0;
        int curNum = root.val==sum ? 1 : 0;
        int leftNum = count(root.left, sum - root.val);
        int rightNum = count(root.right, sum - root.val);
        return curNum + leftNum + rightNum;
    }
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int curNum = count(root, sum);
        int leftNum = pathSum(root.left, sum);
        int rightNum = pathSum(root.right, sum);
        return curNum + leftNum + rightNum;
    }
}