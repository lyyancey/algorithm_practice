class Problem93{
    public List<String> restoreIpAddresses(String s){
        int len = s.length();
        List<String> res = new ArrayList<>();
        // 如果长度不符合要求，不搜索
        if(len<4 || len>12){
            return res;
        }
        Deque<String> path = new ArrayDeque<>(4);
        int splitTimes = 0;
        dfs(s, len, splitTimes, 0, path, res);
        return res;
    }
    /**
     * 判断s的子区间[left, right] 是否能够成为一个ip段
     * 判断的同时顺便把类型转了
     * 
     * @param s
     * @param left
     * @param right
     * @return 
     */
     private int judgeIfIpSegment(String s, int left, int right){
         int len = right - left + 1;
         // 长度大于一时，不能以0开头
         if(len > 1 && s.charAt(left) == '0'){
             return -1;
         }
         // 转成int 类型
          int res = 0;
          for(int i=left; i<=right; i++){
              res = res*10 + (s.charAt(i)-'0');
          }
          if(res>255){
              return -1;
          }

          return res;
     }
     private void dfs(String s, int len, int split, int begin, Deque<String> path, List<String> res){
         if(begin == len){
             if(split == 4){
                 res.add(String.join(".", path));
             }
             return ;
         }
         // 看到剩下长度有问题了，就退出(剪枝),len-begin 表示剩余的还未分割的字符串的位数
         if(len-begin <(4-split) || len-begin > 3 *(4-split)){
             return ;
         }
         for(int i=0; i<3; i++){
             if(begin+i>=len){
                 break;
             }
             int ipSegment = judgeIfIpSegment(s, begin, begin+i);
             if(ipSegment != -1){
                 // 在判断是 ip字段的情况下，才去截取
                 path.addLast(ipSegment+"");
                 dfs(s, len, split+1, begin+i+1, path, res);
                 path.removeLast();
             }
         }
     }
}