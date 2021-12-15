class Problem712{
    // 自顶向下
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2){
        int n = s1.length(), m = s2.length();
        memo = new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(s1, 0, s2, 0);
    }
    private int dp(String s1, int i, String s2, int j){
        int res = 0;
        if(i == s1.length()){
            for(; j<s2.length(); j++){
                res += s2.charAt(j);
            }
            return res;
        }
        if(j == s2.length()){
            for(; i<s1.length(); i++){
                res += s1.charAt(i);
            }
            return res;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j] = dp(s1, i+1, s2, j+1);
        }else{
            memo[i][j] = Math.min(dp(s1, i+1, s2, j)+s1.charAt(i), dp(s1, i, s2, j+1)+s2.charAt(j));
        }
        return memo[i][j];
    }
    // 自底向上
    public int minimumDeleteSum(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        // base case
        int res = 0;
        for(int i=1; i<=n; i++){
            res += s1.charAt(i-1);
            dp[i][0] = res;
        }
        res = 0;
        for(int j=1; j<=m; j++){
            res += s2.charAt(j-1);
            dp[0][j] = res;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j]+s1.charAt(i-1), dp[i][j-1]+s2.charAt(j-1));
                }
            }
        }
        return dp[n][m];
    }
}