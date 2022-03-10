class Problem518{
    public int change(int amount, int[] coins){
        int N = coins.length; //物品的数量
        int W = amount; // 
        // 定义dp数组，dp[i][j] 表示用前n种硬币能凑出数值j的方法有多少种
        int[][] dp = new int[N+1][W+1];
        // base case dp[0..N][0] = 1 无论给定几种硬币，凑出数值为0的方案只有一种， dp[0][0...W]=0 无论给定数值是多少，没有硬币都凑不出来
        // dp[0][0] = 1
        for(int i=0; i<=N; i++) dp[i][0] = 1;
        for(int n=1; n<=N; n++){
            for(int w=1; w<=W; w++){
                if(w<coins[n-1]){//当前硬币的面值大于要凑的数值，则
                    dp[n][w] = dp[n-1][w]; // 用前n-1个数值凑
                }else{ // 否则
                    dp[n][w] = dp[n][w-coins[n-1]] + // 用前n-1种硬币凑面值w-coins[n-1]的方法数，加上
                               dp[n-1][w]; // 不用当前这种面值的硬币凑面值为w的方法数
                }
            }
        }
        return dp[N][W];
    }
}