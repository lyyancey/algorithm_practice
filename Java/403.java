import java.util.Map;

class Problempublic403 {
    //方法一与方法二公用
    Map<Integer, Integer> map = new HashMap<>();
    //方法二用
    Map<String, Boolean> cache = new HashMap<>();
    public boolean canCross(int[] stones){
        int n = stones.length;
        for(int i = 0;i<n;i++){
            map.put(stones[i], i);
        }
        if(!map.containsKey(1))return false;
        return dfs(stones, n, 1, 1);
    }
    boolean dfs(int[] ss, int n, int u, int k){
        if(u==n-1)return true;
        for(int i=-1;i<=1;i++){
            if(k+i==0)continue;
            int next = ss[u]+k+i;
            if(map.containsKey(next)){
                boolean cur = dfs(ss, n, map.get(next), k+i);
                if(cur)return true;
            }
        }
        return false;
    }
    public boolean canCross1(int[] stones){
        int n = stones.length;
        for(int i = 0;i<n;i++){
            map.put(stones[i], i);
        }
        if(!map.containsKey(1))return false;
        return dfs1(stones, n, 1,1);
    }
    public boolean dfs1(int[] ss,int n ,int u,int k){
        String key = u+"_"+k;
        if(u==n-1)return true;
        if(cache.containsKey(key))return cache.get(key);
        for(int i = -1;i<=1;i++){
            if(k+i==0)continue;
            int next = ss[u]+k+i;
            if(map.containsKey(next)){
                boolean cur = dfs(ss, n, map.get(next), k+i);
                cache.put(key, cur);
                if(cur)return true;
            }
        }
        cache.put(key, false);
        return false;
    }
}
