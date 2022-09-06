class Problem110 {
        /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] A) {
        // write your code here
        if(A==null || A.length==0|| A[0].length==0){
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int[][] f = new int[2][n];
        int old = 1, now = 0, t1=0, t2 = 0;
        for(int i=0; i<m; i++){
            old = now;
            now = 1-now;
            for(int j=0; j<n; j++){
                f[now][j] = A[i][j];
                if(i==0 && j==0){
                    continue;
                }
                if(i>0){
                    t1 = f[old][j];
                }else{
                    t1 = Integer.MAX_VALUE;
                }
                if(j>0){
                    t2 = f[now][j-1];
                }else{
                    t2 = Integer.MAX_VALUE;
                }
                f[now][j]+=Math.min(t1, t2);
            }
        }
        return f[now][n-1];
    }
}
