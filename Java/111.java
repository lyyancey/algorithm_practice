class Problem111{
    public int minDepth(TreeNode root){
        if(root == null)return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if(leftDepth == 0) return rightDepth+1; // 左子树为空直接返回右子树加一
        if(rightDepth == 0) return leftDepth +1; // 同理，右子树为空，直接返回左子树 + 1
        // 同时为空的情况包含到上面的情况里了
        int minDepth = Math.min(leftDepth, rightDepth); //都不为空，则返回最短的那条路径
        return minDepth+1;
    }
}