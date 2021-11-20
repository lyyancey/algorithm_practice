class Problem51{
    private List<List<String>> res = new ArrayList<>();
    //输入棋盘的长，返回所有合法的位置
    public List<List<String>> solveNQueens(int n){
        // '.'表示空，'Q'表示皇后，初始化空棋盘
        char[][] chess = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(chess[i], '.');
        }
        // 已经不能放置皇后的列(被占用)
        boolean[] usedCol = new boolean[n];
        // 已经不能放置皇后的正斜线，按右上角到左下角排列，共2n-1条
        boolean[] usedSlash = new boolean[2*n-1];
        // 已经不能放置皇后的反斜线，按左上角到右下角排列，共2n-1条
        boolean[] usedBackSlash = new boolean[2*n-1];
        backtrack(chess, 0, usedCol, usedSlash, usedBackSlash);
        return res;
    }
    // 路径 : chess 中小于row的那些行都已经成功放置了皇后
    // 选择列表 : 第row行的所有列都是放置皇后的选择
    // 结束条件 : row超过棋盘的最后一行
    private void backtrack(char[][] chess, int row, boolean[] usedCol, boolean[] usedSlash, boolean[] usedBackSlash){
        // 触发结束条件
        if(row == chess.length){
            res.add(construct(chess));
            return;
        }
        for(int col=0; col<chess.length; col++){
            // 对合法的选择进行回溯操作
            // 分别检查列，左上方， 右上方是否存在皇后冲突，都不冲突即为合法选择。
            if(!usedCol[col] && !usedSlash[row-col+usedCol.length-1] && !usedBackSlash[row+col]){
                // 做选择
                chess[row][col] = 'Q';
                usedCol[col] = true;
                usedSlash[row-col+usedCol.length-1] = true;
                usedBackSlash[row+col] = true;
                backtrack(chess, row+1, usedCol, usedSlash, usedBackSlash);
                // 撤销选择
                chess[row][col] = '.';
                usedCol[col] = false;
                usedSlash[row-col+usedCol.length-1] = false;
                usedBackSlash[col+row] = false;
            }
        }
    }
    private List<String> construct(char[][] chess){
        // 数组转List
        List<String> path = new ArrayList<>();
        for(char[] chars : chess){
            path.add(new String(chars));
        }
        return path;
    }
}