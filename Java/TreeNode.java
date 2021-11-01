public class TreeNode {
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
     // 递归的前序遍历
     public void recurPreOrder(TreeNode root, List<Integer> result){
         if(root == null){
             return ;
         }
         result.add(root.val);
         recurPreOrder(root.left, result);
         recurPreOrder(root.right, result);
     }
     //递归版的中序遍历
     public void recurInOrder(TreeNode root, List<Integer> result){
         if(root == null){
             return;
         }
         recurInOrder(root.left, result);
         result.add(root.val);
         recurInOrder(root.right, result);
     }
     // 递归版的后序遍历
     public void recurPostOrder(TreeNode root, List<Integer> result){
         if(root == null){
             return ;
         }
         recurPostOrder(root.left, result);
         recurPostOrder(root.right, result);
         result.add(root.val);
     }
     //迭代版前序遍历
     public List<Integer> loopPreorderTraversal(TreeNode root){
         List<Integer> result = new LinkedList<>();
         if(root == null){
             return result;
         }
         Stack<TreeNode> stack = new Stack<>();
         stack.push(root);
         while(!stack.isEmpty()){
             TreeNode node = stack.pop();
             result.add(node.val);
             if(node.right != null){
                 stack.push(node.right);
             }
             if(node.left != null){
                 stack.push(node.left);
             }
         }
         return result;
     }
     //迭代版中序遍历
     public List<Integer> loopInorderTraversal(TreeNode root){
         List<Integer> result = new LinkedList<>();
         Stack<TreeNode> stack = new Stack<>();
         TreeNode cur = root;
         while(cur != null || !stack.isEmpty()){
             if(cur !=null){
                 stack.push(cur);
                 cur = cur.left;
             }else{
                 cur = stack.pop();
                 result.add(cur.val);
                 cur = cur.right;
             }
         }
         return result;
     }
     public List<Integer> loopPostorderTraverse(TreeNode root){
         List<Integer> result = new LinkedList<>();
         if(root == null){
             return result;
         }
         Stack<TreeNode> stack = new Stack<>();
         stack.push(root);
         while(!stack.isEmpty()){
             TreeNode node = stack.pop();
             result.add(node.val);
             if(node.left != null){
                 stack.push(node.left);
             }
             if(node.right != null){
                 stack.push(node.right);
             }
         }
        Collections.reverse(result);
        return result;
     }
     public void recurLevelOrder(List<List<Integer>> resList, TreeNode root, int deep){
         if(root == null)return ;
         deep++;
         if(resList.size() < deep){// 如果结果数量小于遍历深度
            List<Integer> item = new ArrayList<>();
            resList.add(item);
         }
         resList.get(deep-1).add(root.val);
         recurLevelOrder(resList, root.left, deep);
         recurLevelOrder(resList, root.right, deep);
     }
     public List<List<Integer>> loopLevelOrder(TreeNode root){
         List<List<Integer>> resList = new LinkedList<>();
         if(root == null) return resList;
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         while(!queue.isEmpty()){
             List<Integer> itemList = new ArrayList<>();
             int len = itemList.size();
             while(len > 0){
                 TreeNode temNode = queue.poll();
                 itemList.add(temNode.val);
                 if(temNode.left != null) queue.offer(temNode.left);
                 if(temNode.right != null) queue.offer(temNode.right);
                 len--;
             }
             resList.add(itemList);
         }
         return resList;
     }
}
class Node {
   public int val;
   public Node left;
   public Node right;
   public Node next;

   public Node() {}
   
   public Node(int _val) {
       val = _val;
   }

   public Node(int _val, Node _left, Node _right, Node _next) {
       val = _val;
       left = _left;
       right = _right;
       next = _next;
   }
}