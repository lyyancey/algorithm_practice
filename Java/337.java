import java.util.*;
class Problem337 {
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
    Map<TreeNode, Integer> memo = new HashMap<>(); 
    public int rob(TreeNode root) {
        //如果当前房子为空，返回零
        if(root==null)return 0;
        //先检查dp-缓存中有没有记录从当前房子开始偷的话可以获得的最大价值
        if(memo.containsKey(root))return memo.get(root);
        //若果当前房子可以偷的话
        int do_it =
            //可以获得当前房子的价值
            root.val+
            //和从左子树的子树开始偷可以获得的最大价值
            (root.left==null?0:(rob(root.left.left)+rob(root.left.right)))+
            //还有从右子树的子树开始偷可以获得的最大价值
            (root.right==null?0:(rob(root.right.left)+rob(root.right.right)));
        //如果当前房子不能偷的话
        int not_do = 
            //可以获得从左子树开始偷获得的最大价值
            rob(root.left)+
            //还有从右子树开始偷可以获得的最大价值
            rob(root.right);
        //当前节点所获得的最大值是从当前房子可以偷或者不可以偷两种情况所获得的最大价值中的取最大值
        int res = Math.max(do_it, not_do);
        //记录一下在当前节点可以获得的最大值
        memo.put(root, res);
        //返回当前节点可以获得的最大值
        return res;
    }
    public int rob1(TreeNode root){
        //res是一个一维数组
        //res[0]表示如果当前的屋子不偷的话可以获得的最大价值
        //res[1]表示如果当前房子偷的话可以获得的最大价值
        int[] res = dp(root);
        //返回两种情况中的最大值
        return Math.max(res[0], res[1]);
    }
    private int[] dp(TreeNode root){
        //如果当前节点为空，则偷与不偷都是零
        if(root==null)return new int[]{0,0};
        //左节点偷与不偷可以获得的最大价值
        int[] left = dp(root.left);
        //右节点偷与不偷可以获得的最大价值
        int[] right = dp(root.right);
        //如果当前节点偷的话
        int do_rob =
            //可以获得当前节点的价值
            root.val+
            //左节点不偷可以获得的最大价值
            left[0]+
            //右节点不偷可以获得的最大价值
            right[0];
        //如果当前节点不偷的话
        int not_rob =
            //左侧节点偷与不偷取决于获取的价值，取获取的价值高的那个
            Math.max(left[0],left[1])+
            //右侧节点同理
            Math.max(right[0], right[1]);
        //返回当前节点偷与不偷可以获得的最大价值
        return new int[]{do_rob, not_rob};   
    }
}
