class Problem153 {
    public int findMin(int[] nums) {
        int right = nums.length-1,left = 0;
        int mid = 0;
        /**
         * 
         */
        while(left<right){
            mid = left +(right-left)/2;
            if(nums[mid]<nums[right]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return nums[left];
    }
    public static void main(String[] args){
        Problem153 p = new Problem153();
        int[] nums = {3,1,2};
        int k = p.findMin(nums);
        System.out.println(k);
    }
}