class Problem80{
    public int removeDuplicates(int[] nums) {
         int n =nums.length;
         if(n<=2)return n;
         int slow =2, fast = 2;
         while(fast<n){
             if(nums[slow-2]!=nums[fast]){
                 nums[slow] = nums[fast];
                 slow++;
             }
             fast++;
         }
         return slow;
    }
    public static void main(String[] args){
        Problem80 p = new Problem80();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int x = p.removeDuplicates(nums);
        System.out.println(x);
        for(int i=0;i<x;i++){
            System.out.println(nums[i]);
        }
    }
}