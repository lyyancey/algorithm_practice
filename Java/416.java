class Problem416{
    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int x : nums) sum += x; // 求和
        if(sum%2 != 0) return false; //如果和为单数，必不能完全分割
        int W = sum / 2; //背包容量
        int N = nums.length; //物品个数
        // dp数组
        boolean[][] dp = new boolean[N+1][W+1];
        // base case
        for(int i=0; i<N; i++) dp[i][0] = true; // 不管有几个物品，肯定能装满容量为0的背包
        for(int n=1; n<=N; n++){
            for(int w=1; w<=W; w++){
                if(w<nums[n-1]){// 当前容量w小于第n个物品的重量
                    dp[n][w] = dp[n-1][w]; // 能否装满取决于前n-1个物品能否正好装满容量为w的背包
                }else{// 否则
                    dp[n][w] = // 能否正好装满背包，取决于
                                dp[n-1][w-nums[n-1]] || //装下当前物品时，前n-1个物品，是否能正好装满容量为w-nums[n-1]的背包，或者
                                dp[n-1][w]; //不装当前物品的情况下，前n-1个物品是否能正好装下容量为w的背包
                }
            }
        }
        return dp[N][W];
    }
}