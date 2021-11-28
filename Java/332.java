class Problem332{
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            String src = ticket.get(0), dst = ticket.get(1);
            if(!map.containsKey(src)){
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }
    private void dfs(String cur){
        while(map.containsKey(cur) && map.get(cur).size()>0){
            String tem = map.get(cur).poll();
            dfs(tem);
        }
        res.add(cur);
    }
}