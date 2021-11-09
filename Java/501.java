class Problem501{
    List<Integer> res = new ArrayList<>();
    int base, count, maxCount;
    public int[] findMode(TreeNode root){
        dfs(root);
        int[] answer = new int[res.size()];
        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
    private void dfs(TreeNode root){
        if(root == null){
            return ;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }
    private void update(int val){
        if(base == val){
            count ++;
        }else{
            count = 1;
            base = val;
        }
        if(count == maxCount){
            res.add(base);
        }
        if(count > maxCount){
            res.clear();
            maxCount = count;
            res.add(base);
        }
    }
    public int[] findMode0(TreeNode root){
        TreeNode cur = root, pre = null;
        while(cur != null){
            if(cur.left == null){
                update(cur.val);
                cur = cur.right;
            }else{
                pre = cur.left;
                while(pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left
                }else{
                    pre.right = null;
                    update(cur.val);
                    cur = cur.right;
                }
            }
        }
        int[] answer = new int[res.size()];
        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
}