import java.util.Arrays;
import java.utils.*;
class Problem377{
    //暴力递归
    public int combinationSum4(int[] nums, int target) {
        if(target==0)return 1;
        int res = 0;
        for(int num:nums){
            if(target>=num){
                res += combinationSum4(nums, target-num);
            }
        }
        return res;
    }
    //记忆化搜索
    private int[] memo;
    public int combinationSum40(int[] nums, int target) {
        this.mome = new int[target+1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        int res = search(nums, target);
        return res;
    }
    private int search(int[] nums, int target){
        if(memo[target]!=-1)return memo[target];
        int res = 0;
        for(int num : nums){
            if(num<=target){
                res += search(nums, target-num);
            }
        }
        memo[target] = res;
        return res;
    } 
    //动态规划
    public int combinationSum41(int[] nums, int target) {
        Arrays.fill(memo, 0);
        this.memo = new int[target+1];
        memo[0]=1;
        for(int i=0;i<target;i++){
            for(int num:nums){
                if(i+num<=target){
                    memo[i+num]+=memo[i];
                }
            }
        }
        return memo[target];
    }
}
