import java.util.*;
class Problem560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 0,li = 0;
        map.put(0, 1);
        for(int i = 0;i<nums.length;i++){
            li += nums[i];//统计每一个前缀
            //查看map里面是不是有需要的前缀，如果有，那有几个就说明在当前情况下问题有几个解
            int lj = li-k;
            if(map.containsKey(lj)){
                ans += map.get(lj);
            }
            //将当前的前缀放入map
            map.put(li,map.getOrDefault(li, 0)+1);
        }
        return ans;
    }
    public static void main(String[] args){
        Problem560 p = new Problem560();
        int[] x = {1,1,1};
        int k = p.subarraySum(x, 2);
        System.out.println(k);
    }
}
