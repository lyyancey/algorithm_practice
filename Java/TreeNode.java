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
     //Morris Traversal 方法遍历二叉树 非递归 不用栈 O(1)
     //中序
     /**
      * 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点
      * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点
            a. 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子
            b. 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空(恢复树的形状)。输出当前节点。当前节点更新为当前节点的右孩子。
        3. 重复以上1、2 直到当前节点为空。
      */
     public List<Integer> inorderMorrisTraverse(TreeNode root){
         List<Integer> resList = new LinkedList<>();
         TreeNode cur = root, prev = null;
         while(cur !=null){
             if(cur.left  == null){
                 resList.add(cur.val);
                 cur = cur.right;
             }else{
                 prev = cur.left;
                 while(prev.right != null && prev.right != cur){
                     prev = prev.right;
                 }
                 if(prev.right == null){
                     prev.right = cur;
                     cur = cur.left;
                 }else{
                     prev.right = null;
                     resList.add(cur.val);
                     cur = cur.right
                 }
             }
         }
         return resList;
     }
      // 前序
      /**
       * 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点
       * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
       *    a. 如果前驱节点的右孩子为空,将它的右孩子设置为当前节点。输出当前节点(在这里输出，这是与中序遍历唯一一点不同)。
               当前节点更新为当前节点的左孩子。
            b. 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空。当前节点更新为当前节点的右孩子。
         3. 重复以上1、2 直到当前节点为空。
       */
      public List<Integer> preorderMorrisTraversal(TreeNode root){
          TreeNode cur = root, prev = null;
          List<Integer> resList = new LinkedList<>();
          while(cur != null){
              if(cur.left == null){
                  resList.add(cur.val);
                  cur = cur.right;
              }else{
                  prev = cur.left;
                  while(prev != null &&  prev != cur){
                      prev = prev.right;
                  }
                  if(prev.right == null){
                      resList.add(cur.val); //the only difference with inorder traversal
                      prev.right = cur;
                      cur = cur.left;
                  }else{
                      prev.right = null;
                      cur= cur.left;
                  }
              }
          }
          return resList;
      }
      // 后序遍历
      // 后续遍历稍显复杂，需要建立一个临时节点dump,令其左孩子是root。并且还需要一个子过程，就是倒序输出某两个节点之间路径上的各个节点。
      /**
       *  当前节点设置为临时节点dump。
       * 1.如果当前节点的左孩子为空，则将其右孩子作为当前节点。
       * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
       *    a. 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
       *    b. 如果前驱节点的右孩子为当前节点，则将它的右孩子重新设为空。倒序输出从当前节点的左孩子到该前驱节点这条路径上的所有节点。
       *      当前节点更新为当前节点的右孩子。
       * 3. 重复以上1、2直到当前节点为空。
       */
      public List<Integer> postorderMorrisTraversal(TreeNode root){
          TreeNode dump = new TreeNode(-1);
          dump.left = root;
          TreeNode cur = dump, prev = null;
          List<Integer> resList = new ArrayList<>();
          while(cur){
              if(cur.left == null){
                  cur = cur.right;
              }else{
                  prev = cur.left;
                  while(prev.right != null && prev.right != cur){
                      prev = prev.right;
                  }
                  if(prev.right == null){
                      prev.right = cur;
                      cur = cur.left;
                  }else{
                      printReverse(cur.left, prev, resList); // call print
                      prev.right = null;
                      cur = cur.right;
                  }
              }
          }
      }
      private void printReverse(TreeNode from, TreeNode to , List<Integer>  resList){
          reverse(from, to);
          TreeNode p = to;
          while(true){
              resList.add(p.val);
              if(p.equals(from)){
                  break;
              }
              p = p.right;
          }
          reverse(to, from);

      }
      private void reverse(TreeNode from, TreeNode to){
          if(from.equals(to)){
              return;
          }
          TreeNode x = from, y = from.right, z = null;
          while(true){
              z = y.right;
              y.right = x;
              x = y
              y = z;
              if(x.equals(to)){
                  break;
              }
          }
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