class Problem704 {
    public int search(int[] nums, int target) {
        int right = nums.length-1, left = 0;//这里用的是闭区间,搜索区间为[right, left]
        while(left<=right){//[left right]
            int mid = left+(right-left)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid]>target)right = mid-1;//搜索区间为[left, mid-1]
            else if(nums[mid]<target)left = mid+1;//搜索区间为[mid+1, right]
        }
        return -1;
    }
    //下面是一个开区间的例子
    public int search1(int[] nums, int target){
        int right = nums.length,left = 0;//这里的搜索区间便是[left,right)
        while(left < right){//因为搜索区间是开区间，所以等号是取不到的,当取到等号便越界了.
            int mid = left + (right-left)/2;
            if(nums[mid]==target){//找到目标，返回索引
                return mid;
            }else if(nums[mid]>target){//中间值比目标值大，将区间调整为[left, mid)
                right = mid;
            }else if(nums[mid]<target){
                left = mid+1;//中间值比目标值小，将区间调整为[mid, right);
            }
        }
        return -1;//找不到，返回-1；
    }
    //寻找左侧边界,开区间版本
    public int left_bound(int[] nums, int target){
        int right = nums.length,left = 0;//搜索区间为[left, right)
        int mid=0;
        while(left < right){
            mid = left +(right-left)/2;
            if(nums[mid]==target){
                right = mid;//当找到目标值时，不着急返回，而是缩小搜寻的右边界
            }else if(nums[mid]>target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }
        }
        return left;
    }
    //再来一个寻找左侧边界闭区间的例子
    public int left_bound_close(int[] nums, int target){
        int right = nums.length-1,left=0;//搜索区间设置为[left, right]
        int mid = 0;
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid]==target){
                right = mid - 1;//找到目标时，不着急返回，缩小右侧边界为[left, mid-1]
            }else if(nums[mid]>target){
                right = mid-1;//缩小右侧边界为[left, nid-1]
            }else if(nums[mid]<target){
                left = mid+1;//将搜索边界调整为[mid+1, right]
            }
        }
        return left-1;
    }
}