class Problem77{
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k){
        if(k>n) return res;
        List<Integer> track = new ArrayList<>();
        backtrack(n+1, 1, k, track);
        return res;
    }
    private void backtrack(int n, int start, int k, List<Integer> track){
        if(track.size() == k){
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i=start; i<n; i++){
            // 做选择
            track.add(i);
            // 回溯
            backtrack(n, i+1, k, track);
            // 撤销选择
            track.remove(track.size()-1);
        }
    }
}