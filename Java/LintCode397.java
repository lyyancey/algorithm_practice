class Problem397 {
        /**
     * @param a: An array of Integer
     * @return: an integer
     */
    int result = 1;
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        int n = A.length;
        if(n == 0){
            return 0;
        }
        cacl(A, n);
        int i=0, j=n-1;
        while(i<j){
            int tem = A[i];
            A[i] = A[j];
            A[j] = tem;
            i++;
            j--;
        }
        cacl(A, n);
        return result;
    }
    private void cacl(int[] A, int n){
        int[] f = new int[n];
        for(int i=0; i<n; i++){
            f[i] = 1;
            if(i>0 && A[i]>A[i-1]){
                f[i] = f[i-1]+1;
            }
            if(f[i]>result){
                result = f[i];
            }
        }
    }
}
