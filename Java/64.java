class Problem64{
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return dp(grid, m, n);
    }
    int dp(int[][] grid, int m, int n){
        if(m==0 && n==0) return grid[0][0]
        if(m<=0 || n<=0){
            return Integer.MAX_VALUE;
        }
        if(memo[m][n] != -1){
            return memo[m][n];
        }
        memo[m][n] = Math.min(dp(grid, m-1, n), dp(grid, m, n-1))+grid[m][n];
        return  memo[m][n];
    }
}