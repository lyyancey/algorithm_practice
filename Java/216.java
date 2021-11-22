class Problem216{
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n){
        List<Integer> track = new ArrayList<>();
        backtrack(k, n, 1, track, 0);
        return res;
    }
    private void backtrack(int k, int n, int start, List<Integer> track, int sum){
        if(track.size() == k && sum == n){
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i = start; i<10; i++){
            // 剪枝
            if(sum+i>n){
                return ;
            }
            // 做选择
            track.add(i);
            // 回溯
            backtrack(k, n, i+1, track, sum+i);
            // 撤销选择
            track.remove(track.size()-1);
        }
    }
}