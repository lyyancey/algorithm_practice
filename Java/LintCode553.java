import java.util.Arrays;

class Problem553{
    public int maxKilledEnemies(char[][] A) {
        // write your code here
        if(A==null || A.length==0 || A[0].length == 0){
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int[][] f = new int[m][n];
        int[][] res = new int[m][n];
        int i, j;
        for(i=0; i<m; i++){
            Arrays.fill(res[i], 0);
        }
        // UP
        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if(A[i][j] == 'W'){
                    f[i][j] = 0;
                }else{
                    f[i][j] = 0;
                    if(A[i][j] == 'E'){
                        f[i][j] = 1;
                    }
                    if(i>0){
                        f[i][j]+=f[i-1][j];
                    }
                }
                res[i][j] += f[i][j];
            }
        }
        for(i=m-1; i>=0; i--){
            for(j=0;j<n; j++){
                if(A[i][j] == 'W'){
                    f[i][j] = 0;
                }else{
                    f[i][j] = 0;
                    if(A[i][j] == 'E'){
                        f[i][j] = 1;
                    }
                    if(i<n-1){
                        f[i][j] += f[i+1][j];
                    }
                }
                res[i][j] += f[i][j];
            }
        }
        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if(A[i][j] == 'W'){
                    f[i][j] = 0;
                }else{
                    f[i][j] = 0;
                    if(A[i][j] == 'E'){
                        f[i][j] = 1;
                    }
                    if(j>0){
                        f[i][j]+= f[i][j-1];
                    }
                }
                res[i][j] += f[i][j];
            }
        }
        for(i=0;i<m; i++){
            for(j=n-1; j>=0; j--){
                if(A[i][j] == 'W'){
                    f[i][j] = 0;
                }else{
                    f[i][j] = 1;
                    if(A[i][j] == 'E'){
                        f[i][j] = 1;
                    }
                    if(j<n-1){
                        f[i][j]+= f[i][j+1];
                    }
                }
                res[i][j] += f[i][j];
            }
        }
        int result = 0;
        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if(A[i][j] == 0){
                    result = Math.max(result, res[i][j]);
                }
            }
        }
        return result;
    }
}
