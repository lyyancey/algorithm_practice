class Problem938 {
    private int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        getSum(root, low,high);
        return sum;
    }
    public void getSum(TreeNode root, int low,int high){
        if(root == null)return;
        getSum(root.left, low, high);
        if(root.val>=low&&root.val<=high){
            sum+=root.val;
        }
        getSum(root.right, low, high);
    }
}
