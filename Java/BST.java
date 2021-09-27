public class BST {
    //判断BST的合法性
    public boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }
    // 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        // base case
        if(root == null)return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法的BST
        if(min!=null && root.val>=min.val)return false;
        if(max!=null && root.val<=max.val)return false;
        // 限定左子树的最大值是root.val, 右子树的最小值是root.val
        return isValidBST(root.left, min, root)&&isValidBST(root.right, root, max);
    }

    //在 BST中搜索一个数
    public boolean isInBST(TreeNode root, int target){
        if(root == null)return false;
        if(root.val == target)return true;
        if(root.val < target) return isInBST(root.right, target);
        if(root.val > target) return isInBST(root.left, target);
        // 其实不需要这个返回值
        return false;
    }
    //在 BST 中插入一个数
    public TreeNode insertIntoBST(TreeNode root, int val){
        if(root == null)return new TreeNode(val);
        if(root.val < val) root.right = insertIntoBST(root.right, val);
        if(root.val > val) root.left = insertIntoBST(root.left, val);
        return root;
    }
    // 在 BST中删除一个节点
    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null)return null;
        if(root.val == key){
            // 处理只有一个子节点的情况
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            //处理有两个子节点的情况
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    private TreeNode getMin(TreeNode node){
        //BST 最左边的就是最小的
        while(node.left != null)node = node.left;
        return node;
    }
}
