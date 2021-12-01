class Problem55{
    public boolean canJump(int[] nums){
        int n = nums.length - 1;
        int fastest = 0;
        for(int i=0; i<n; i++){
            fastest = Math.max(fastest, i+nums[i]);
            if(fastest <= i){
                return false;
            }
        }
        return true;
    }
}