class Problem131{
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s){
        if(s.length() == 0){
            return res;
        }
        List<String> track = new ArrayList<>();
        char[] charArray = s.toCharArray();
        backtrack(charArray, s.length(), 0, track);
        return res;
    }
    private void backtrack(char[] charArray, int len, int start, List<String> track){
        if(start == len){
            res.add(new ArrayList<>(track));
            return ;
        }
        for(int i=start; i<len; i++){
            if(!isPalindromeString(charArray, start, i)){
                continue;
            }
            track.add(new String(charArray, start, i+1-start));
            backtrack(charArray, len, i+1, track);
            track.remove(track.size()-1);
        }
    }
    private boolean isPalindromeString(char[] charArray, int left, int right){
        while(left<right){
            if(charArray[left] != charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 利用动态规划得到所有子串是否回文
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s){
        int len = s.length();
        if(len==0){
            return res;
        }
        char[] charArray = s.toCharArray();
        // 预处理
        // 状态: dp[i][j] 表示s[i][j]是否是回文
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程 : 在s[i] == s[j]的时候，dp[i][j] 参考 dp[i+1][j-1]
        for(int right=0; right<len; right++){
            // 注意： left <= right 取等号表示需要一个字符的时候也需要判断
            for(int left=0; left<=right; left++){
                if(charArray[left] == charArray[right] && (right-left<=2 || dp[left+1][right-1])){
                    dp[left][right] = true;
                }
            }
        }
        List<String> track = new ArrayList<>();
        dfs(s, 0, len, dp, stack);
        return res;
    }
    private void dfs(String s, int start, int len, boolean[][] dp, List<String> stack){
        if(start == len){
            res.add(new ArrayList<>(stack));
            return ;
        }
        for(int i=start; i<len; i++){
            if(dp[start][i]){
                track.add(s.substring(start, i+1));
                dfs(s, i+1, len, dp, stack);
                track.remove(track.size()-1);
            }
        }
    }
}