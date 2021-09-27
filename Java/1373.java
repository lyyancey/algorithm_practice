class Problem1373{
    int sum;
    public int maxSumBST(TreeNode root){
        traverse(root);
        return sum;
    }
    private int[] traverse(TreeNode root){
        if(root == null){
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        //递归计算左右子树
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        //后序遍历
        int[] res = new int[4];
        //判断以root 为根的二叉树是不是BST
        if(left[0]==1 && right[0]==1 && root.val>left[2] && root.val < right[1]){
            //以root为根的二叉树是BST
            res[0] = 1;
            //计算以root为根的这棵BST的节点最小值
            res[1] = Math.min(root.val, left[1]);
            // 计算以root为根的这棵BST的节点最大值
            res[2] = Math.max(root.val, right[2]);
            //计算以root为根的这颗BST的所有节点之和
            res[3] = left[3] + right[3] + root.val;
            //更新全局变量,取最大值，因为节点的值有可能是复数
            sum = Math.max(sum, res[3]);
        }else{
            //以root为根的二叉树不是BST
            res[0] = 0;
        }
        return res;
    }
}