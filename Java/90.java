class Problem90{
    public List<List<Integer>> subsetsWithDup(int[] num){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        if(num.length == 0){
            return res;
        }
        List<Integer> track = new ArrayList<>();
        backtrack(num, 0, track, res);
        return res;
    }
    private void backtrack(int[] num, int start, List<Integer> track, List<List<Integer>> res){
        res.add(new ArrayList<>(track));
        for(int i=start; i<num.length; i++){
            if(i>start && num[i] == num[i-1]){
                continue;
            }
            track.add(num[i]);
            backtrack(num, i+1, track, res);
            track.remove(track.size()-1);
        }
    }
}