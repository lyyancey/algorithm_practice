clss Problem516{
    public int longestPalindromeSubseq(String s){
        int n = s.length();
        //状态 dp[i][j] 从第i个字符到第j个字符最长回文子串的长度  dp[0][n-1]
        int[][] dp = new int[n][n];
        // base case dp[i][i]=1
        for(int i=0; i<n; i++){
            dp[i][i] = 1;
        }
        //状态转移方程
        for(int i=0; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i-1][j+1] +2;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j+1]);
                }
            }
        }
        return dp[n-1][0];
    }
}