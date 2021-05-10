import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
}
class Problem872{
    private List<Integer> list;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        list = new ArrayList<>();
        dfs(root1);
        List<Integer> list1 = new ArrayList<>(list);
        list.clear();
        dfs(root2);
        if(list.size()!=list1)return false;
        for(int i=0;i<list1.size();i++){
            if(list1.get(i)!=list.get(i))return false;
        }
        return true;

    }
    private void dfs(TreeNode root){
        if(root==null)return;
        dfs(root.left);
        if(root.left==null&&root.right==null){
            list.add(root.val);
        }
        dfs(root.right);
    }
}