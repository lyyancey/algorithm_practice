class Problem283 {
    public void moveZeroes(int[] nums){
        int slow = 0;
        for(int fast = 0;fast < nums.length;fast++){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for(;slow<nums.length;slow++){
            nums[slow] = 0;
        }
    }
    public void moveZeroes0(int[] nums){
        for(int i=0,j=0;i<nums.length;i++){
            if(nums[i] != 0){
                int tem = nums[i];
                nums[i] = nums[j];
                nums[j] = tem;
                j++;
            }
        }
    }
}
