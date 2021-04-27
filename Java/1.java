import java.util.Arrays;
import java.util.Map;
import java.utils.*;
class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(map.get(target-nums[i])!=null){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}