class Problem300{
    public int lengthOfLIS(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i=0; i<len; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int res = dp[0];
        for(int i=1; i<len; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    // 二分查找的方法
    public int lengthOfLIS(int[] nums){
        int[] top = new int[nums.length];
        // 牌堆数初始化为0
        int piles = 0;
        for(int i=0; i<nums.length; i++){
            // 要处理的扑克牌
            int poker = nums[i];
            /*********搜索左侧边界的二分查找*********/
            int left = 0, right = piles;
            while(left < right){
                int mid = (left+right) / 2;
                if(top[mid]>poker){
                    right = mid;
                }else if(top[mid]<poker){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
            /***************************************/

            //没有找到合适的牌堆，新建一堆
            if(left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是LIS长度
        return piles;
    }
}