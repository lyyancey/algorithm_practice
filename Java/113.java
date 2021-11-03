class Problem113{
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<Integer> rootList = new ArrayList<>();
        List<List<Integer>> resList = new LinkedList<>();
        getPathSum(root, targetSum, rootList, resList);
        return resList;
    }
    public void getPathSum(TreeNode root, int target, List<Integer> temList, List<List<Integer>> resList){
        if(root == null){
            return;
        }
        temList.add(root.val);
        if(root.val == target && root.left==null && root.right==null){
            resList.add(temList);
            return;
        }
        List<Integer> leftRes = new ArrayList<>(temList);
        //leftRes.addAll(temList);
        List<Integer> rightRes = new ArrayList<>(temList);
        //rightRes.addAll(temList);
        getPathSum(root.left, target - root.val, leftRes, resList);
        getPathSum(root.right, target - root.val, rightRes, resList);
    }
}