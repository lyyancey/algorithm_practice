class Problem583{
    // 自顶向下
    int[][] memo;
    public int minDistance(String s1, String s2){
        int n = s1.length(), m = s2.length();
        memo =new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(s1, 0, s2, 0);
    }
    private int dp(String s1, int i, String s2, int j){
        if(i == s1.length()) return s2.length() - j;
        if(j == s2.length()) return s1.length() - i;
        if(memo[i][j] != -1) return  memo[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = dp(s1, i+1, s2, j+1);
        }else{
            memo[i][j] = Math.min(dp(s1, i+1, s2, j), dp(s1, i, s2, j+1))+1;
        }
        return memo[i][j];
    }


    // 自底向上
    public int minDistance(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        //base case dp[0][0] = 0, dp[i][0] = i, dp[0][j] = j;
        for(int i=0; i<=n; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=m; j++){
            dp[0][j] = j;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+1;
                }
            }
        }
        return dp[n][m];
    }
}