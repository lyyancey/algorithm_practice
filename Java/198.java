import java.util.*;
class Problem198{
    private int[] mamo;
    public int rob(int[] nums){
        this.mamo = new int[nums.length];
        Arrays.fill(mamo, -1);
        return dp1(nums, 0);
    }
    //递归版
    private int dp0(int[] nums,int start){
        //检查越界
        if(start>=nums.length){
            return 0;
        }
        //两者取最大值
        int res = Math.max(
            //如果当前这个屋不能偷，则去下一个屋    
            dp0(nums, start+1), 
            //如果可以偷，则当前这个屋的钱加上下下个屋的钱
            nums[start]+dp0(nums, start+2));
        return res;
    }
    private int dp1(int[] nums, int start){
        //检查是否越界
        if(start >= nums.length){
            return 0;
        }
        //如果缓存数组中有当前的答案，则直接返回
        if(mamo[start]!=-1)return mamo[start];
        //返回当前房间偷与不偷可以获得的最大价值
        int res = Math.max(
            //不偷的话直接去下一个房间
            dp1(nums, start+1), 
            //偷的话可以得到当前房间的价值和下下个房间可以获得的最大价值
            nums[start]+dp1(nums,start+2));
        //记录一下当前房间可以获得的最大价值
        mamo[start] = res;
        return res;
    }
    private int dp2(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+2];
        //这里的dp[i]=x表示从当前房子开始偷可以获得的最大价值
        for(int i=n-1;i>=0;i--){
            //从后往前开始偷
            dp[i] = Math.max(
                //当前房子不偷的话，可以获得下一个房子可以获得的最大价值
                dp[i+1], 
                //如果偷当前的房子，则可以获得当前房子可以获得的价值加上下下个房子可以获得的最大价值
                nums[i]+dp[i+2]);
        }
        //返回从第一个房子开始偷时可以获得的最大价值
        return dp[0];
    }
    private int dp3(int[] nums){
        int n = nums.length;
        //当前的状态只和下一个状态和下下个状态有关
        int dp_i = 0,dp_2 = 0, dp_3=0;
        for(int i = n-1;i>=0;i--){
            dp_i = Math.max(dp_2, nums[i]+dp_3);
            dp_3 = dp_2;
            dp_2 = dp_i;
        }
        return dp_i;
    }
}