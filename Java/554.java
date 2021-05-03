import java.util.*;
class Problem554{
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> l : wall){
            int key = 0;
            for(int num:l){
                key +=num;
                map.put(key, map.getOrDefault(key, 0)+1);
            }
            map.remove(key);
        }
        int max = 0;
        for(int x : map.keySet()){
            max  = Math.max(max, map.get(x));
        }
        return wall.size()-max;
    }
}