class Problem81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int right1=0,left2=1;
        while(left2<n){
            if(nums[left2]<nums[right1])break;
            left2++;
            right1++;
        }
        int left1 = 0,right2=n,mid=0;
        while(left1<=right1){
            mid = left1+(right1-left1)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]>target){
                right1 = mid - 1;
            }else if(nums[mid]<target){
                left1 = mid + 1;
            }
        }
        while(left2 < right2){
            mid = left2+ (right2-left2)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]>target){
                right2 = mid;
            }else if(nums[mid]<target){
                left2 = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] x = {2,5,6,0,0,1,2};
        Problem81 p = new Problem81();
        boolean t = p.search(x, 3);
        System.out.println(t);

    }
}
