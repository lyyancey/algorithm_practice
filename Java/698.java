class Problem698{
    // 以数字的视角
    public boolean canPartitionKSubsets(int[] nums, int k){
        // 排除一些基本情况
        if(k > nums.length) return false;
        int sum = 0;
        for(int v : nums) sum += v;
        if(sum % k != 0) return false;
        // k 个桶 (集合)，记录每个桶装的数字之和
        int[] bucket = new int[k];
        // 理论上每个桶(集合)中数字的和
        int target = sum / k;
        // 穷举，看看nums是否能划分成k个和为target的子集
        return backtrack(nums, 0, bucket, target);
    }
    private boolean backtrack(int[] nums, int index, int[] bucket, int target){
        if(index == nums.length){
            // 检查所有桶的数字之和是否都是target
            for(int i=0; i<bucket.length; i++){
                if(bucket[i] != target){
                    return false;
                }
            }
            // nums 成功平分成 k 个子集
            return true;
        }
        // 穷举 nums[index] 可能装入的桶
        for(int i=0; i<bucket.length; i++){
            // 剪枝， 桶装满了
            if(bucket[i]+nums[index] > target){
                continue;
            }
            // 将 nums[index] 装入 bucket[i]
            bucket[i] += nums[index];
            // 递归穷举下一个数字的选择
            if(backtrack(nums, index+1; bucket, target)){
                return true;
            }
            // 撤销选择
            bucket[i] -= nums[index];
        }
        // nums[index] 装入哪个桶都不行
        return false;
    }


    // 以桶的视角
    public boolean canPartitionKSubsets(int[] nums, int k){
        if(k>nums.length){
            return false;
        }
        int sum = 0;
        for(int v : nums) sum += v;
        if(sum % k != 0) return false;
        int target = sum / k;
        boolean[] usedNum = new boolean[nums.length];
        return backtrack(k, 0, nums, 0, target, usedNum);
    }
    private boolean backtrack(int k, int bucket, int nums, int start, int target, boolean[] usedNum){
        if(k==0){
            return true;
        }
        if(bucket == target){
            return backtrack(--k, 0, nums, 0, target, usedNum);
        }
        for(int i=start; i<nums.length; i++){
            if(usedNum[i]){
                continue;
            }
            if(bucket+nums[i] >target){
                continue;
            }
            bucket += nums[i];
            usedNum[i] = true;
            if(backtrack(k, bucket, nums, i+1, target, usedNum)){
                return true;
            }
            bucket -= nums[i];
            usedNum[i] = false;
        }
        return false;
    }
}