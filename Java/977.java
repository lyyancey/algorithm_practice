class Problem977{
    public int[] sortedSquares(int[] nums){
        int[] res = new int[nums.length-1];
        int lo=0, hi=nums.length-1, k=nums.length-1;
        while(lo <= hi){
            if(nums[lo]*nums[lo] < nums[hi]*nums[hi]){
                res[k] = nums[hi]*nums[hi];
                hi--;
            }else{
                res[k] = nums[lo]*nums[lo];
                lo++;
            }
            k--;
        }
        return res;
    }
}