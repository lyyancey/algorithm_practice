class Problem154{
   public int findMin(int[] nums){
      int left = 0, right = nums.length()-1;
      while(left<right){
         int mid = left + (right - left)/2;
         if(nums[mid]>=right){
            right = mid;
         }else{
            left = mid;
         }
      }
      return left;
   } 
}