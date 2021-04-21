import java.util.*;
class Problem220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            Long u = nums[i] * 1L;
            //得到比大于等于u的最大值
            Long l = set.floor(u);
            //得到比u大的最小值
            Long r = set.ceiling(u);
            if(l!=null && u-l<=t)return true;
            if(r!=null && r-u<=t)return true;
            set.add(u);
            if(i>=k)set.remove(Long.valueOf(nums[i-k]));
        }
        return false;
    }
    public boolean containsNearbyAlmostDuplicate0(int[] nums, int k, int t){
        long size = t+1L;
        int n = nums.length;
        //存储维护大小为k的窗口
        /**
         * 这里map中的每个item代表一个桶，每个桶只能存储一个数字，原因就是，每个桶存放的是一个区间的数字，
         * 这个区间中的任意两个元素都会满足条件，所以一旦当前数字所得到的桶的编号已经存在了，则必然满足条件了。
         */
        Map<Long, Long> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            long u = nums[i]*1L;
            //计算当前数字应该属于的桶的编号
            long idx = getIndx(u, size);
            //如果该桶在窗口中已经存在，因为每个编号相同的桶，存放的数字满足abs(nums[i] - nums[j]) <= t，故返回true
            if(map.containsKey(idx))return true;
            //拿到左边桶的编号
            long l = idx-1;
            //拿到右边桶的编号
            long r = idx+1;
            //如果左边的桶存在，并且满足绝对值小于等于t的条件，则必然满足条件
            if(map.containsKey(l)&&u-map.get(l)<=t)return true;
            //同上
            if(map.containsKey(r)&&map.get(r)-u<=t)return true;
            //将当前数字放入窗口中
            map.put(idx, u);
            //移除不属于窗口中的桶
            if(i>=k)map.remove(getIndx(nums[i-k]*1L, size));
        }
        return false;
    }
    private Long getIndx(long u, long size){
        /**
         * 这里计算的是桶的编号，size加一是为了正确的分桶，当u为复数的时候因为0已经归属为正数了
         * 所以复数要整体向右偏移一位，而这时复数的第一个桶已经被正数占用了，桶的编号要向左偏移一位
         */
        return u >= 0 ? u/size:(u+1)/size-1;
    }
}
