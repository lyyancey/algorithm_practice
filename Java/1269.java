class Problem1269 {

    public int numWays(int steps, int arrLen) {
        int max  = Math.min(steps/2, arrLen-1);
        int[][] f = new int[max+1][steps+1];
        f[steps][0] = 1;
        for(int i =steps-1;i>=0;i--){
            for(int j=0;j<=max;j++){
                f[i][j] = (f[i][j]+f[i+1][j])%mod;
                if(j-1>=0)f[i][j] = (f[i][j]+f[i][j-1])%mod;
                if(j+1<=max)f[i][j] = (f[i][j]+f[i][j+1])%mod;
            }
        }
        return f[0][0];
    }
}
