class Problem651{
    int maxA(int N){
        int[] dp = new int[N+1];
        dp[0] = 0;
        for(int i=1; i<=N; i++){
            dp[i] = dp[i-1]+1;// 只按下一次A
            for(int j=2; j<i; j++){
                dp[i] = Math.max(dp[i], dp[j-2]*(i-j+1));
            }
        }
        return dp[N];
    }
}