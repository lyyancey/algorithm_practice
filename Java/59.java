class Problem59{
    public int[][] generateMatrix(int n){
        int row_x=0, row_y=n-1, col_x=0, col_y=n-1;
        int[][] res = new int[n][n];
        for(int i=1; i<=n*n;){
            for(int x=col_x; x<=col_y; x++){
                res[row_x][x] = i;
                i++;
            }
            row_x++;
            for(int x=row_x;x<=row_y;x++){
                res[x][col_y] = i;
                i++;
            }
            col_y--;
            for(int x=col_y;x>=col_x;x--){
                res[row_y][x] = i;
                i++;
            }
            row_y--;
            for(int x=row_y;x>=row_x;x--){
                res[x][col_x] = i;
                i++;
            }
            col_x++;
        }
        return res;
    }
}