class Problem421{
    public int findMaximumXOR(int[] nums) {
        if(nums.length<=1){
            return 0;
        }
        int res = -1;
        for(int j=1;j<nums.length;j++){
            for(int i=0;i<j;i++){
                int max = nums[i]^nums[j];
                if(res<max){
                    res = max;
                }
            }
        }
        return res;
    }
    } 
}
