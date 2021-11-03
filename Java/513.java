class Problem513{
    public int findBottomLeftValue(TreeNode root){
        int[] res = getLeftLeaveValue(root, 0);
        return res[0];
    }
    private int[] getLeftLeaveValue(TreeNode node, int height){
        if(root == null){ //当前节点为空，则
            return new int[]{-1, -1};// 不参与比较，返回高度的最小值
        }
        if(node.left == null && node.right == null){ //左右子树均为空时，则
            return new int[] {node.val, height+1};//返回当前节点的高度，以及节点值
        }
        int[] leftRes = getLeftLeaveValue(node.left, height+1); //递归得到左子树的最左边节点的值
        int[] rightRes = getLeftLeaveValue(node.right, height+1); //递归得到右子树的最左边节点的值
        return leftRes[1] >= rightRes[1] ? leftRes:rightRes; //返回高度最大的节点的值，节点深度相同时，返回最左边节点的值
    }
}