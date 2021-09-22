class Problem654{
    public TreeNode constructMaximumBinaryTree(int[] nums){
        return buildMaxBinaryTree(nums, 0, nums.length-1);
    }
    private TreeNode buildMaxBinaryTree(int[] nums, int lo, int hi){
        if(lo > hi)return null;
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for(int i=lo;i<=hi;i++){
            if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = buildMaxBinaryTree(nums, lo, maxIdx-1);
        root.right = buildMaxBinaryTree(nums, maxIdx+1, hi);
        return root;
    }
}
