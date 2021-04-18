class Problem26{
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 1, fast = 1;
        while(fast<n){
            if(nums[slow-1]!=nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
