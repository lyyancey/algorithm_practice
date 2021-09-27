class Problem106{
    public TreeNode buildTree(int[] inorder, int[] postorder){
        return build(inorder, 0, inorder.length-1, postorder, 0,postorder.length-1);
    }
    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] posorder, int posStart, int posEnd){
        if(inStart > inEnd)return null;
        int rootVal = posorder[posEnd];
        int index = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, inStart, index-1, posorder, posStart, posStart+leftSize-1);
        root.right = build(inorder, index+1, inEnd, posorder, posStart+leftSize, posEnd-1);
        return root;
    }
}
