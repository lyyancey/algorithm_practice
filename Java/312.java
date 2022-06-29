class Problem312{
    public int maxCoins(int[] nums){
        int n = nums.length;

        int[] points = new int[n+2]; //在nums两端添加两个虚拟节点
        points[0] = points[n+1] = 1; //为了不影响最终连乘的结果，虚拟节点的值为 1
        // 将原来节点的值复制到新的数组
        for(int i=1; i<n+1; i++){
            points[i] = nums[i-1];
        }
        /**
         * dp[i][j]表示在区间(i, j)之间可以获得的最大硬币数量
         * basecase为 0<i<n+1, j<i+1时 dp[i][j]=0, 因为此时i与j之间根本没有气球可以戳破
         */
        int[][] dp = new int[n+2][n+2];
        for(int i=n; i>=0; i--){
            for(int j=i+1; j<n+2; j++){
                for(int k=i+1; k<j; k++){// k表示在i与j之间最后戳破的气球的索引
                    dp[i][j] = Math.max(//求最大值
                            dp[i][j],
                            dp[i][k]+dp[k][j]+points[i]*points[k]*points[j]
                    );
                }
            }
        }
        return dp[0][n+1];
    }
}