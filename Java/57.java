class Problem57{
    public int[][] insert(int[][] intervals, int[] ne){
        int n = intervals.length;
        if(n == 0){
            return new int[][]{newInterval};
        }
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i<n;i++){
            if(intervals[i][1]<ne[0]){
                res.add(intervals[i]);
                if(i==n-1){
                    res.add(ne);
                    break;
                }
            }else{
                int head = Math.min(intervals[i][0],ne[0]);
                int k = i;
                int tail = -1;
                while(intervals[k][1]<ne[1] && k<n)k++;
                if(k>=n){
                    res.add(new int[]{head, ne[1]});
                    break;
                }
                if(intervals[k][0]>ne[1]){
                    tail = Math.max(intervals[k-1][1], ne[1]);
                    res.add(new int[]{head, tail});
                    i=k-1;
                }else{
                    tail = Math.max(intervals[k][1], ne[1]);
                    i=k;
                }
            }
        }
        int[][] result = new int[res.length][];
        for(int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
