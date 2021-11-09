class Problem235{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while(true){
            if(ancestor.val > p.val && ancestor.val > q.val){//当前节点既大于p又大于q,则
                ancestor = ancestor.left;//转向左节点
            }else if(ancestor.val < p.val && ancestor.val < q.val){//当前节点值既小于p又小于q,则
                ancestor = ancestor.right;//转向右节点
            }else{//否则就是当前节点
                break;//跳出
            }
        }
        return ancestor;
    }
}