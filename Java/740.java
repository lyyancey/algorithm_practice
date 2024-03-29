class Problem740 {
    public int deleteAndEarn(int[] nums) {
        if(nums==null||nums.length == 0){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }
        int len = nums.length;
        int max = 0;
        for(int x : nums){
            max = Math.max(max, x);
        }
        int[] all = new int[max+1];
        for(int item:nums){
            all[item]++;
        }
        int[] dp = new int[max+1];
        dp[1] = all[1]*1;
        dp[2] = Math.max(dp[1], all[2]*2);
        for(int i=2;i<=max;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+i*all[i]);
        }
        return dp[max];
    }  
}
