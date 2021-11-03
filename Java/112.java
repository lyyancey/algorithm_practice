class Problem112{
    public boolean hasPathSum(TreeNode root, int targetSum){
        if(root==null){
            return false;
        }
        if(root.val == targetSum && root.left==null && root.right == null){
            return true;
        }
        boolean leftRes = hasPathSum(root.left, targetSum-root.val);
        boolean rightRes = hasPathSum(root.right, targetSum - root.val);
        return leftRes || rightRes;
    }
}