import java.util.Map;

class Problem137{
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int k = map.getOrDefault(num, 0)+1;
            if(k==3){
                map.remove(num);
            }else{
                map.put(num, k);
            }
        }
        int res = (Integer)map.keySet().toArray()[0];
        return res;
    }
}
