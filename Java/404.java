class Problem404{
    public int sumOfLeftLeaves(TreeNode root){
        return getSum(root, false);
    }
    public int getSum(TreeNode node, boolean isLeft){
        if(node == null ){
            return 0;
        }
        int leftSum = getSum(node.left, true);
        int rightSum = getSum(node.right, false);
        if(isLeft && node.left== null && node.right ==null){
            return node.val + leftSum + rightSum;
        }
        return leftSum + rightSum;
    }
}