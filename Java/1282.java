import java.util.*;

class Problem1282{
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<groupSizes.length; i++) {
            int val = groupSizes[i];
            String key = String.valueOf(val);
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            if(list.size() == val) {
                res.add(list);
                map.remove(String.valueOf(val));
                list = new ArrayList<>();
                list.add(i);
                map.put(key, list);
            }else {
                list.add(i);
                map.put(key, list);
            }
        }
        for(String val : map.keySet()){
            res.add(map.get(val));
        }
        return res;
    }

    public List<List<Integer>> groupThePeople0(int[] gs){
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = gs.length;
        for(int i=0; i<n; i++){
            List<Integer> list = map.getOrDefault(gs[i], new ArrayList<>());
            list.add(i);
            map.put(gs[i], list);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Integer key : map.keySet()){
            List<Integer> cur = new ArrayList<>();
            for(int val : map.get(key)){
                cur.add(val);
                if(cur.size() == key){
                    res.add(cur);
                    cur = new ArrayList<>();
                }
            }
        }
        return res;
    }
}