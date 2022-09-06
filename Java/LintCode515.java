class Problem515 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] f = new int[n+1][3];
        f[0][0] = f[0][1] = f[0][2] = 0;
        for(int i=1; i<=n; i++){
            for(int k=0; k<3; k++){
                f[i][k] = Integer.MAX_VALUE;
                for(int j=0; j<3; j++){
                    if(j == k){
                        continue;
                    }
                    if(f[i-1][j]+costs[i-1][k]<f[i][k]){
                        f[i][k] = f[i-1][j]+costs[i-1][k];
                    }
                }
            }
        }
        int res = Math.min(f[n][0], Math.min(f[n][1], f[n][2]));
        return res;
    }
}
