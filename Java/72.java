class Problem72{
    // 回溯算法， 暴力、超时
    public int minDistance(String s1, String s2){
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        return dp(sc1, s1.length()-1, sc2, s2.length()-1);
    }
    private int dp(char[] sc1, int i, char[] sc2, int j){
        //base case
        if(i == -1) return j+1;
        if(j == -1) return i+1;
        if(sc1[i] == sc2[j]){
            return dp(sc1, i-1, sc2, j-1);
        }else{
            return min(dp(sc1, i, sc2, j-1)+1, dp(sc1, i-1, sc2, j)+1, dp(sc1, i-1, sc2, j-1)+1); 
        }
    }
    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
    // 添加备忘录 , 可以通过，效率有亿点点的低
    Map<String, Integer> memo = new HashMap<>();
    public int minDistance(String s1, String s2){
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        return dp(sc1, s1.length()-1, sc2, s2.length()-1);
    }
    private int dp(char[] sc1, int i, char[] sc2, int j){
        //base case
        if(i == -1) return j+1;
        if(j == -1) return i+1;
        String key = i+"-"+j;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int res = 0;
        if(sc1[i] == sc2[j]){
            res = dp(sc1, i-1, sc2, j-1);
        }else{
            res =  min(dp(sc1, i, sc2, j-1)+1, dp(sc1, i-1, sc2, j)+1, dp(sc1, i-1, sc2, j-1)+1); 
        }
        memo.put(key, res);
        return res;
    }
    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }

    // 动态规划的解法
    public int minDistance(String s1, String s2){
        int m = s1.length(), n = s2.length();
        //dp[i][j] 的含义是s1[0, i-1] 与s2[0, j-1]的最小编辑距离是多少
        // base case为dp[i][0] = i  dp[0][j] = j
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=n;j++){
            dp[0][j] = j;
        }
        for(int i=1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+1);
                }
            }
        }
        return dp[m][n];
    }
    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}