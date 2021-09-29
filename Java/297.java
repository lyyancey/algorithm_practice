//前序遍历的方法
class PreTraverseSolution{
    String SEP = ",";
    String NULL = "#";
    //将树编码成一个字符串
    public String serialize(TreeNode root){
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }
    private void serialize(TreeNode root, StringBuffer sb){
        if(root == null){
            sb.append(NULL).append(SEP);
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
    //将树解码成一个字符串
    public TreeNode deserialize(String data){
        LinkedList<String> list = new LinkedList<>();
        for(String s : data.split(",")){
            list.add(s);
        }
        return deserialize(list);
    }
    private TreeNode deserialize(LinkedList<String> list){
        if(list.isEmpty()){
            return null;
        }
        String s = list.removeFirst();
        if(NULL.equals(s)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }
}
//后序遍历的方法
class LastTraverseSolution{
    private String SEP = ",";
    private String NULL = "#";
    public String serialize(TreeNode root){
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }
    private void serialize(TreeNode root, StringBuffer sb){
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        serialize(root.left, sb);
        serialize(root.right, sb);
        sb.append(root.val);
    }
    public TreeNode deserialize(String data){
        LinkedList<String> list = new LinkedList<>();
        for(String s : data.split(",")){
            list.add(s);
        }
        return deserialize(list);
    }
    private TreeNode deserialize(LinkedList<String> list){
        if(list.isEmpty()){
            return null;
        }
        String v = list.removeLast();
        if(NULL.equals(v))return null;
        TreeNode root = new TreeNode(Integer.parseInt(v));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }
}
class MediaTraverseSolution{
    private String SEP = ",";
    private String NULL = "#";
    public String serialize(TreeNode root){
        if(root == null) return "";
        //初始化队列
        Queue<TreeNode> q = new LinkedList<>();
        //将root节点加入队列
        q.offer(root);
        //创建StringBuffer保存结果
        StringBuffer sb = new StringBuffer();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(node.val).append(SEP);
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data){
        if(data.isEmpty())return null;
        //所有的节点
        String[] nodes = data.split(SEP);
        //第一个为根节点
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        //创建队列，存放所有的上层节点
        Queue<TreeNode> q = new LinkedList<>();
        //根节点加入队列
        q.offer(root);
        //根据层序遍历顺序，创建二叉树
        for(int i=1; i<nodes.length;){
            //从队列中取出父节点
            TreeNode parent = q.poll();
            //左孩子
            String left = nodes[i++];
            if(!NULL.equals(left)){//如果左孩子不是空节点，就
                parent.left = new TreeNode(Integer.parseInt(left));//创建新节点，并将父节点的左孩子指向它,并
                q.offer(parent.left);//讲左孩子加入队列
            }else{//如果左孩子是空节点, 则
                parent.left = null;//将父节点的左孩子指向空
            }
            String right = nodes[i++];//取出右孩子
            if(!NULL.equals(right)){//如果右孩子不为空
                TreeNode rightNode = new TreeNode(Integer.parseInt(right));//创建右孩子,并
                parent.right = rightNode;//将父节点的右孩子指向它，并
                q.offer(parent.right);//将右孩子加入队列
            }else{//如果右孩子为空，则
                parent.right = null;//将父节点的右孩子指向空
            }
        }
        return root;//返回根节点
    }
}