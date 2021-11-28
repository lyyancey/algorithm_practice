class Problem47{
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        // 用过了为 true
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, track, res);
        return res;
    }
    private void backtrack(int[] nums, boolean[] used, List<Integer> track, List<List<Integer>> res){
        if(track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return ;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i]||(i>0 && nums[i] == nums[i-1] && used[i-1])){
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, track, res);
            track.remove(track.size()-1);
            used[i] = false;
        }
    }
}