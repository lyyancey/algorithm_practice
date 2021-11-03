class Problem617{
    public TreeNode megeTrees(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null){
            return root1==null ? root2 : root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}