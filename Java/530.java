class Problem530{
    int pre = -1;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        getMin(root);
        return res;
    }
    private void getMin(TreeNode root){
        if(root == null){
            return ;
        }
        getMin(root.left);
        if(pre != -1){
            res = Math.min(res, root.val-pre);
            pre = root.val;
        }else{
            pre = root.val;
        }
        getMin(root.right);
    }
}