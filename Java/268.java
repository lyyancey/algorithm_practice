class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i=1;i<=nums.length;i++){
            res += i;
            res -= nums[i-1];
        }
        return res;
    }
    public int missingNumber(int[] nums){
        int res = 0;
        for(int i = 1;i<=nums.length;i++){
            res ^= i;
            res ^= nums[i-1];
        }
        return res;
    }
}