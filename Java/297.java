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
        if(root == null)return "";
        StringBuffer sb = new StringBuffer();
        //初始化队列，将root加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data){
        if(data.isEmpty())return null;
        String[] nodes = data.split(SEP);
        //第一个元素就是root的值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        //队列q记录父节点，将root加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i=1; i<nodes.length; ){
            //队列中存在的都是父节点
            TreeNode parent = q.poll();
            String left = nodes[i++];
            if(!NULL.equals(left)){
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            }else{
                parent.left = null;
            }
            String right = nodes[i++];
            if(!NULL.equals(right)){
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            }else{
                parent.right = null;
            }
        }
        return root;
    }
}