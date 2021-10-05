class Problem209{
    public int minSubArrayLen(int target, int[] nums){
        int  res=nums.length+1, sum=0;
        for(int lo=0, hi=0;hi<nums.length;hi++){
            sum += nums[hi];
            while(sum >= target){
                sum -= nums[lo];
                if(sum < target){
                    res = res > hi-lo+1 ? hi-lo+1:res;
                }
                lo++;
            }
        }
        if(res==nums.length+1){
            return 0;
        }
        return res;
    }
}