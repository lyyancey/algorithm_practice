class Problem53{
    public int maxSubArray(int[] nums){
        int n = nums.length;
        if(n == 0)return 0;
        int[] dp = new int[n];
        // base case
        dp[0] = nums[0];
        for(int i=1; i<n; i++){
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }
        int res = dp[0];
        for(int i=1; i<n; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    // 优化空间复杂度
    public int maxSubArray(int[] nums){
        int n = nums.length;
        if(n == 0)return 0;
        // base case
        int dpPre = nums[0], dpCur = 0, res = dpPre;
        for(int i=1; i<n; i++){
            dpCur = Math.max(nums[i], dpPre + nums[i]);
            dpPre = dpCur;
            res = Math.max(res, dpCur);
        }
        return res;
    }
}