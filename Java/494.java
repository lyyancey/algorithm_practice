class Problem494{
    // 回溯算法
    private int result = 0;
    public int findTargetSumWays(int[] nums, int target){
        if(nums.length == 0)return 0;
        backtrack(nums, 0, target);
        return result;
    }
    private void backtrack(int[] nums, int i, int rest){
        // base case
        if(i==nums.length){
            if(rest == 0){
                // 说明正好可以凑出target
                result++;
            }
            return;
        }
        // 给nums[i]选择-号
        rest += nums[i];
        backtrack(nums, i+1, rest);
        rest -= nums[i];

        // 给nums[i] 选择+号
        rest -= nums[i];
        backtrack(nums, i+1, rest);
        rest += nums[i];
    }

    // 添加备忘录修改版
    private Map<String, Integer> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target){
        return backtrack(nums, 0, target);
    }
    private int backtrack(int[] nums, int index, int target){
        if(index == nums.length){
            if(target == 0){
                return 1;
            }
            return 0;
        }
        String key = index+"_"+target;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int res = backtrack(nums, index+1, target-nums[index]) + backtrack(nums, index+1, target+nums[index]);
        map.put(key, res);
        return res;
    }

    // 动态规划
    public int findTargetSumWays(int[] nums, int target){
        int sum = 0;
        for(int num : nums) sum += num;
        // 两种非法的情况
        if(sum + target < 0 || (sum + target)%2 ==1){
            return 0;
        }
        return subsets(nums, (sum+target)/2);
    }
    // 计算nums中有几个子集的和为sum
    private int subsets(int[] nums, int sum){
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];
        //base case
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(j >= nums[i-1]){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    // 压缩状态版
    private int subsets(int[] nums, int tar){
        int n = nums.length;
        int[] dp = new int[sum-1];
        // base case
        dp[0] =1;
        for(int i=1; i<=n; i++){
            for(int j=sum; j>=0; j--){
                if(j>=nums[i-1]){
                    dp[j] = dp[j] + dp[j-nums[i-1]];
                }
            }
        }
        return dp[sum];
    }

}