class Problem213{
    public int rob(int[] nums) {
        /**
         * 这里的房子是循环的，相邻的房子不能偷所以有三种情况：
         * 1.第一间房子不能偷，最后一间房子可以偷
         * 2.第一间房子可以偷，最后一间房子不能偷
         * 3.第一间房子和最后一间房子都不能偷
         * 但是第三种情况明显选择的余地比前两种情况小，故可以不用考虑
         */
        int n = nums.length;
        //如果只有一间房子，那么最大价值就是这间房子了
        if(n == 1)return nums[0];
        //否则的话，分别对第一种情况和第二种情况试偷，取最大值
        return Math.max(robRange(nums, 0,n-2), robRange(nums, 1, n-1));
    }
    private int robRange(int[] nums, int start, int end){
        int i=0,i_1=0,i_2=0;
        //从后往前偷
        for(int k = end; k>=start;k--){
            //当前房子偷和不偷的两种情况取最大值
            i = Math.max(
                //不偷的话可以获得从下一间房子开始偷的最大价值
                i_1, 
                //偷的话可以获得当前房子可以得到的价值，还有从下下间房子开始偷可以获得的最大价值
                nums[k]+i_2);
            //记录下一间房子的可以获得的最大价值
            i_2 = i_1;
            //记录当前房子可以获得的最大价值
            i_1 = i;
        }
        //返回最后开始偷的房子的最大价值
        return i;
    }
}
