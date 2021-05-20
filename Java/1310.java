class Problem1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ress = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            int res = arr[queries[i][0]];
            for(int j=queries[i][0]+1;j<queries[i][1];j++){
                res ^= arr[j];
            }
            ress[i] = res;
        }
        return ress;
    }
}