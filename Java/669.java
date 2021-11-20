class Problem669{
    public TreeNode trimBST(TreeNode root, int low, int high){
        if(root == null) return null;
        // 如果当前值小于左侧值，直接返回当前节点的右子树的修剪结果
        if(root.val < low) return trimBST(root.right, low, high);
        // 如果当前值大于右侧值，直接返回当前节点的左子树的修剪结果
        if(root.val > high) return trimBST(root.left, low, high);
        // 当前节点的左子树指向左子树的修剪结果
        root.left = trimBST(root.left, low, high);
        // 当前节点的右子树指向右子树的修剪结果
        root.right = trimBST(root.right, low, high);
        // 返回根节点
        return root;
    }
}