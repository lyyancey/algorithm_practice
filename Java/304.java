class NumMatrix {
    /**
    private int[][] matrix;
    public NumMatrix(int[][] matrix){
        this.matrix = matrix;
    }
    public int sumRegion(int row1, int col1, int row2, int col2){
        int sum = 0;
        for(int i = row1;i<=row2;i++){
            for(int j = col1;j<=col2;j++){
                sum += this.matrix[i][j];
            }
        }
        return sum;
    }
    */
    private int[][] sum;
    public NumMatrix(int[][] matrix){
        int n = matrix.length, m= n==0 ? 0:matrix[0].length;
        this.sum = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2){
        row1++;col1++;row2++;col2++;
        return sum[row2][col2]-sum[row1-1][col2]-sum[row2][col1-1]+sum[row1-1][col1-1];
    }
}
