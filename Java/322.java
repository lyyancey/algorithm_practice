class Problem322{
    // 暴力解法，时间比较长，有些测试用例无法通过
    public int coinChange(int[] coins, int amount){
        // 题目要求的最终结果是dp(amount)
        return dp(coins, amount);
    }
    private int dp(int[] coins, int amount){
        //base case
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for(int coin : coins){
            // 计算子问题的结果
            int subProblem = dp(coins, amount-coin);
            // 子问题无解则跳过
            if(subProblem == -1) continue;
            // 在子问题中选择最小值加一，就是当前问题的最优解
            res = Math.min(res, subProblem+1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    // 通过备忘录进行优化
    private int[] memo;
    public int coinChange(int[] coins, int amount){
        memo = new int[amount+1];
        Arrays.fill(memo, -2);
        return dp(coins, amount);
    }
    private int dp(int[] coins, int amount){
        // base case
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(memo[amount] != -2) return memo[amount];
        int res = Integer.MAX_VALUE;
        for(int coin : coins){
            // 求解子问题
            int subProblem = dp(coins, amount - coin);
            // 如果子问题无解则跳过
            if(subProblem == -1) continue;
            //否则，记录当前问题最小值
            res = Math.min(res, subProblem+1);
        }
        // 通过备忘录记录
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        // 返回最值
        return memo[amount];
    }

    // 通过迭代计算
    public int coinChange(int[] coins, int amount){
        // 定义备忘录
        int[] memo = new int[amount+1];
        // 初始化备忘录
        Arrays.fill(memo, amount+1);
        // base case
        memo[0] = 0;
        for(int i=0; i<=amount; i++){
            for(int coin : coins){
                if(i-coin < 0) continue;
                memo[i] = Math.min(memo[i-coin]+1, memo[i]);
            }
        }
        return memo[amount] == amount+1 ? -1 : memo[amount];
    }
}