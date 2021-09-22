import java.util.*;
class Problem652{
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return list;
    }
    private String traverse(TreeNode root){
        if(root == null)return "#";
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = root.val + ","+left+","+right;
        int fre = map.getOrDefault(subTree, 0);
        if(fre == 1){
            list.add(root);
        }
        map.put(subTree, fre+1);
        return subTree;
    }
}
