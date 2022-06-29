import jdk.jfr.events.FileReadEvent;

class Problem486{
    public boolean PredictTheWinner(int[] nums){
        int n = nums.length;
        final int FIRST = 0;
        final int SECOND = 1;
        // dp数组，dp[i][j][FIRST] 表示在[i, j]这个区间中， 先手(FIRST)可以获得的最高分数
        // dp[i][j][SECOND] 表示在[i, j]这个区间中，后手(SECOND)可以获得的最高分数
        int[][][] dp = new int[n][n][2];
        // base case
        for(int i=0; i<n; i++){ // 当区间中只有一个元素时，即0<= i==j <n 时，
            dp[i][i][FIRST] = nums[i]; // 先手获得的分数为nums[i],
            dp[i][i][SECOND] = 0;// 后手由于无法选择，只能获取到0分
        }
        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){
                /**
                 * 当先手选择左边的数字时，此时对于区间[i+1, j]来说它就变成了后手
                 * 它可以获得的最大分数为nums[i]加上在[i+1, j]这个区间后手选择可以获得的最大分数
                 */
                int left = nums[i] + dp[i+1][j][SECOND];
                /**
                 * 同理，如果此时先手选择了右边的数字，此时对于区间[i, j-1]来说它就变成了后手
                 * 他可以获得的最大分数为nums[j] 加上[i, j-1]这个区间后候选择可以获得的最大分数
                 */
                int right = nums[j] + dp[i][j-1][SECOND];
                if(left>right){
                    dp[i][j][FIRST] = left;// 在区间[i, j]中，先手选择左边可以获得的最大分数
                    /**
                     * 当先手在区间[i, j]上选择了左边的数字时，则后手可以获得的最大分数就是[i+1, j]这个区间中先手可以获得的最大分数
                     */
                    dp[i][j][SECOND] = dp[i+1][j][FIRST];
                }else{
                    dp[i][j][FIRST] = right; //在区间[i, j]上先手选择了右边的数字时可以获得的最大分数
                    /**
                     * 当先手在区间[i, j]上选择了右边的数字时，则后手在区间[i,j]上可以获得的最大分数就是，在区间[i, j-1]上先手可以获得的最大分数
                     */
                    dp[i][j][SECOND] = dp[i][j-1][FIRST];
                }
            }
        }
        return dp[0][n-1][FIRST]>dp[0][n-1][SECOND];
    }
}