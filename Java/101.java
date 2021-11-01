class Problem101{
    public boolean isSymmetric(TreeNode root){
        if(root == null)return true;
        return testSymmetric(root.left, root.right);
    }
    private boolean testSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left ==null || right == null){
            return false;
        }
        boolean res = left.val == right.val;
        boolean leftRes = testSymmetric(left.left, right.right);
        boolean rightRes = testSymmetric(left.right, right.left);
        return res && leftRes && rightRes;
    }
}