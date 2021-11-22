class Problem78{
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums){
        // 记录走过的路径
        ArrayList<Integer> track = new ArrayList<>(); 
        backtrack(nums, 0, track);
        return res;
    }
    private void backtrack(int[] nums, int start, ArrayList<Integer> track){
        res.add(new ArrayList<>(track));
        for(int i=start; i<nums.length; i++){
            // 做选择
            track.add(nums[i]);
            // 回溯
            backtrack(nums, i+1, track);
            // 撤销选择
            track.remove(track.size()-1);
        }
    }
}