class Problem491{
    public List<List<Integer>> findSubsequences(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        dfs(nums, 0, Integer.MIN_VALUE, track, res);
        return res;
    }
    private void dfs(int[] nums, int cur, int last, List<Integer> track, List<List<Integer>> res){
        if(cur == nums.length){
            if(track.size()>1){
                res.add(new ArrayList<>(track));
            }
            return;
        }
        if(nums[cur] >= last){
            track.add(nums[cur]);
            dfs(nums, cur+1, nums[cur], track, res);
            track.remove(track.size()-1);
        }
        if(nums[cur] != last){
            dfs(nums, cur+1, last, track, res);
        }
    }
}