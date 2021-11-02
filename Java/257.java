class Problem257{
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root){
        StringBuffer sb = new StringBuffer();
        getBinaryPath(sb, root);
        return res;
    }
    private void getBinaryPath(StringBuffer sb, TreeNode node){
        if(root == null){
            res.add(sb.toString());
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null){
            res.add(sb.toString());
            return;
        }
        if(root.left != null){
            getBinaryPath(new StringBuffer(sb.toString()+"->"), root.left);
        }
        if(root.right != null){
            getBinaryPath(new StringBuffer(sb.toString()+ "->"), root.right);
        }
    }
    private void constructPaths(TreeNode root, String path, List<String> paths){
        if(root != null){
            StringBuffer sb = new StringBuffer(path);
            sb.append(root.val);
            if(root.left == null && root.right == null){
                paths.add(sb.toString());
            }else{
                sb.append("->");
                constructPaths(root.left, sb.toString(), paths);
                constructPaths(root.right, sb.toString(), paths);
            }
        }
    }
}