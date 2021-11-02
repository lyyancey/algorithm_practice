class Problem222{
    public int countNodes(TreeNode root){
        if(root == null) return 0;
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        return leftNum + rightNum +1;
    }
    public int countNodes0(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftLeve = countLevels(root.left);
        int rightLevel = countLevels(root.right);
        if(leftLeve == rightLevel){
            return countNodes0(root.right) + (1 << leftLeve);
        }else{
            return countNodes0(root.left) + (1 << rightLevel);
        }
    }
    private int countLevels(TreeNode root){
        int level = 0;
        while(root != null){
            level ++;
            root = root.left;
        }
        return level;
    }
}