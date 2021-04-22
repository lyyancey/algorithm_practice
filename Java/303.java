class NumArray {
    private int[] sums;
    public NumArray(int[] nums) {
        int n = nums.length;
        this.sums = new int[n+1];
        for(int i=0;i<n;i++){
            sums[i+1] = sums[i]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return this.sums[right+1] - this.sums[left];
    }
}