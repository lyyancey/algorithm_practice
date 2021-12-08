class Problem509{
    // 带备忘录的递归解法,自上而下的解法
    public int fib(int n){
        // 备忘录全部初始化为0
        int memo = new int[n+1];
        // 进行带备忘录的递归
        return helper(memo, n);
    }
    private int helper(int[] memo, int n){
        // base case
        if(n==0 || n==1) return n;
        // 已经计算过，不用再计算了
        if(memo[n] != 0)return memo[n];
        memo[n] = helper(memo, n-1)+helper(memo, n-2);
        return memo[n];
    }
    // 循环迭代的解法，属于自下而上的解法
    public int fib1(int n){
        if(n==0) return 0;
        int[] dp = new int[n+1];
        // base case
        dp[0] = 0, dp[1] = 1;
        // 状态转移
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    // 优化空间复杂度
    public int fib(int n){
        if(n<1) return 0;
        if(n == 1 || n == 2){
            return 1;
        }
        int pre = 1, cur = 1;
        for(int i=3; i<=n; i++){
            int sum = pre+cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }

}