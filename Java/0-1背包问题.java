class Problem01{
    int knapsack(int W, int N, int[] wt, int[] val){
        // base case 初始化 dp[0][0...W] = 0, dp[0...N][0] = 0
        int[][] dp = new int[N+1][W+1];
        for(int i=1; i<=N; i++){
            for(int w=1; w<=W; w++){
                if(w-wt[i-1]<0){
                    // 装不进去当前的物品了
                    dp[i][w] = dp[i-1][w];
                }else{
                    dp[i][w] = Math.max(
                        // 把第i个物品装进背包
                        dp[i-1][w] = val[i-1] + dp[i-1][w-wt[i-1]],
                        // 不把第i个物品装进背包
                        dp[i-1][w];
                    );
                }
            }
        }
        return dp[N][W];
    }
}