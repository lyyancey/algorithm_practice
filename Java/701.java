class Problem701{
        public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode cur = root, par = null;
        while(cur != null){
            par = cur;
            if(cur.val > val){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        if(par.val > val){
            par.left = new TreeNode(val);
        }else{
            par.right = new TreeNode(val);
        }
        return root;
    }
}