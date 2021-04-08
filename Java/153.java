class Problem153 {
    public int findMin(int[] nums) {
        int right = nums.length-1,left = 0;
        int mid = 0;
        /**
         * 左>中  中<右
         * 左
         *        右
         *    中
         * 左<中  中<右
         *         右  
         *     中
         * 左
         * 
         * 左<中  中>右
         *     中
         * 左 
         *       右
         * 
         * 左<中 中<右 (不存在)
         * 左
         *    中
         *        右
         * 所以第一种情况与第二种情况可以归纳为一类，此时最小值在左侧，可以收缩右边界
         * 第三种情况是一类，此时可以收缩左边界
         */

        while(left<right){//结束条件为left==right 此时搜索区间内只有一个值还没有被搜索到，故必然是最小值
            mid = left +(right-left)/2;//地板除 mid靠近left
            if(nums[mid]<nums[right]){//如果nums[mid]<nums[right]
                right = mid;//缩小右边界，为什么是right = mid 而不是right=mid-1? 可能是为了最后right ==left == nums[min]吧 
            }else{
                left = mid+1;//除此之外缩小左边界
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