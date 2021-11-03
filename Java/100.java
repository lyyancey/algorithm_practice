class Problem100{
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q ==null){
            return false;
        }
        boolean res = p.val == q.val;
        boolean leftRes = isSameTree(p.left, q.left);
        boolean rightRes = isSameTree(p.right, q.right);
        return res && leftRes && right;
    }
}