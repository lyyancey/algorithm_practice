class Problem101{
    public boolean isSymmetric(TreeNode root){
        if(root == null)return true;
        return testSymmetric(root.left, root.right);
    }
    private boolean testSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left ==null || right == null){
            return false;
        }
        boolean res = left.val == right.val;
        boolean leftRes = testSymmetric(left.left, right.right);
        boolean rightRes = testSymmetric(left.right, right.left);
        return res && leftRes && rightRes;
    }
    private boolean loopTestSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left == null || root.right==null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if(leftNode.val != rightNode.val){
                return false;
            }
            if(leftNode.left != null && rightNode.right !=null){
                queue.offer(leftNode.left);
                queue.offer(rightNode.right);
            }else{
                if(leftNode.left != null || rightNode.right !=null){
                    return false;
                }
            }
            if(leftNode.right !=null && rightNode.left !=null){
                queue.offer(leftNode.right);
                queue.offer(rightNode.left);
            }else{
                if(leftNode.right != null || rightNode.left !=null){
                    return false;
                }
            }
        }
        return true;
    }
}