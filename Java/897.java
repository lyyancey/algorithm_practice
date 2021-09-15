import java.util.List;


class Problem897{
    //递归，自己写的渣代码
    List<Integer> l;
    public TreeNode increasingBST(TreeNode root) {
        l = new ArrayList<>();
        search(root);
        TreeNode head = new TreeNode();
        TreeNode node=head;
        for(int num:l){
            node.right = new TreeNode();
            node = node.right;
            node.val = num;
        }
        return head.right;
    }
    public void search(TreeNode root){
        if(root==null)return;
        search(root.left);
        l.add(root.val);
        search(root.right);

    }
    //第二种
    List<TreeNode> list = new ArrayList<>();
    public TreeNode increasingBST0(TreeNode root){
        dfs(root);
        TreeNode head = new TreeNode();
        TreeNode cur = head;
        for(TreeNode node:list){
            cur.right = node;
            node.left = null;
            cur = node;
        }
        return head.right;
    }
    private void dfs(TreeNode node){
        if(node==null)return;
        dfs(node.left);
        list.add(node);
        dfs(node.right);
    }

}
