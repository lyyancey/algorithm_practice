class Problem63{
    public int uniquePathsWithObstacles(int[][] A){
        int m = A.length;
        if(m == 0){
            return 0;
        }
        int n = A[0].length;
        if(n == 0)return 0;
        int[][] f = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                if(A[i][j] == 1){
                    f[i][j] = 0;
                }else{
                    if(i==0 && j==0){
                        f[i][j] = 1;
                    }else{
                        if(i-1>=0){
                            f[i][j]+=f[i-1][j];
                        }
                        if(j-1>=0){
                            f[i][j]+= f[i][j-1];
                        }
                    }
                }
            }
        }
        return f[m-1][n-1];
    }
}
