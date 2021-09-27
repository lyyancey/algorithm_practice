import java.util.*;
class Problem95{
    public List<TreeNode> generateTrees(int n){
        if(n<=0){
            return new LinkedList<TreeNode>();
        }
        return generate(1, n);
    }
    private List<TreeNode> generate(int lo, int hi){
        List<TreeNode> res = new LinkedList<>();
        if(lo>hi){
            res.add(null);
            return res;
        }
        for(int i=lo ; i<=hi; i++){
            List<TreeNode> leftTree = generate(lo, i-1);
            List<TreeNode> rightTree = generate(i+1, hi);
            for(TreeNode left : leftTree){
                for(TreeNode right: rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}