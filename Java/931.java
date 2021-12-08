class Problem931{
    // 会有测试用例超出时间限制
    public int minFallingPathSum(int[][] matrix){
        int res = Integer.MAX_VALUE;
        for(int i=0; i<matrix[0].length; i++){
            res = Math.min(dp(matrix, matrix.length-1, i), res);
        }
        return res;
    }
    int dp(int[][] matrix, int i, int j){
        // 非法索引值检查
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length){
            return 9999;
        }
        // base case
        if(i==0){
            return matrix[i][j];
        }
        // 状态转移
        return matrix[i][j] + min(dp(matrix, i-1, j-1), dp(matrix, i-1, j), dp(matrix, i-1, j+1));
    }
    int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

    // 添加备忘录进行优化
    int[][] memo;
    public int minFallingPathSum(int[][] matrix){
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        // 初始化备忘录里面的值
        memo = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(memo[i],  66666);
        }
        for(int i=0; i<n; i++){
            res = Math.min(res, dp(matrix, n-1, i));
        }
        return res;
    }
    private int dp(int[][] matrix, int i, int j){
        if(i<0 || j<0 || j>=matrix.length){
            return 9999;
        }
        if(i==0){
            return matrix[0][j];
        }
        if(memo[i][j] != 66666){
            return memo[i][j];
        }
        memo[i][j] = matrix[i][j] + min(dp(matrix, i-1, j-1), dp(matrix, i-1, j), dp(matrix, i-1, j+1));
        return memo[i][j];
    }
    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}