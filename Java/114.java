class Problem114 {
    public void flatten(TreeNode root){
        if(root == null)return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;


        TreeNode node = root;
        while(node.right != null){
            node = node.right;
        }
        node.right = right;
    }
}
