class Problem40{
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] can, int target){
        Arrays.sort(can);
        if(can.length==0 || can[0] >target){
            return res;
        }
        List<Integer> track = new ArrayList<>();
        backtrack(can, 0, track, 0, target);
        return res;
    }
    private void backtrack(int[] can, int start, List<Integer> track, int sum,int target){
        if(sum == target){
            res.add(new ArrayList<>(track));
            return ;
        }
        for(int i=start; i<can.length; i++){
            if(sum+can[i] > target){
                return;
            }
            if(i>start && can[i] == can[i-1]){
                continue;
            }
            track.add(can[i]);
            backtrack(can, i+1, track, sum+can[i], target);
            track.remove(track.size()-1);
        }
    }
}