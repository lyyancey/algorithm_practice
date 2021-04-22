import java.util.TreeSet;
import java.utils.*;
class Problem363{
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length, m = n==0?0:matrix[0].length;
        int[][] sum = new int[n+1][m+1];
        int ans = Integer.MIN_VALUE;
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1];
            }
        } 
        for(int row1=1;row1<=n;row1++){
            for(int col1=1;col1<=m;col1++){
                for(int row2=row1;row2<=n;row2++){
                    for(int col2 = col1;col2<=m;col2++){
                        int x = sum[row2][col2] - sum[col1-1][col2]-sum[row2][col1-1]+sum[col1-1][row1-1];
                        if(x<=k){
                            ans = Math.max(x, ans);
                        }    
                    }
                }
            }
        }
        return ans;
    }
    public int maxSumSubmatrix0(int[][] matrix, int k) {
        int n = matrix.length, m=n==0?0:matrix[0].length;
        //预处理前缀和
        int[][] sum = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
            }
        }
        int ans = Integer.MIN_VALUE;
        //遍历矩阵的上边界
        for(int top = 1;top<=n;top++){
            //遍历子矩阵的下边界
            for(int bot = 1;bot<=m;bot++){
                //使用有序集合,维护所有遍历到的右边界
                TreeSet<Integer> ts = new TreeSet<>();
                //这里说的应该是第0项的前缀和是0
                ts.add(0);
                //遍历子矩阵的右边界
                for(int r = 1;r<=m;r++){
                    //通过前缀和计算
                    int right = sum[bot][r] - sum[top-1][r];
                    //通过二分查找left
                    Integer left = ts.ceiling(right - k);
                    if(left != null){
                        int cur = right - left;
                        ans = Math.max(cur, ans);
                    }
                    ts.add(right);
                }
            }
        }
        return ans;
    }
    //有问题
    public int maxSumSubmatrix1(int[][] mat, int k){
        int n = mat.length, m = mat[0].length;
        int[][] sum = new int[m+1][n+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+mat[i-1][j-1];
            }
        }
        boolean isRight = m>n;
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=(isRight?m:n);i++){
            for(int j = i; j<=(isRight?m:n);j++){
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                for(int f = 1;f<=(isRight?m:n);f++){
                    int a = isRight?sum[j][f]-sum[i-1][f]:sum[f][j]-sum[f][i-1];
                    Integer b = ts.ceiling(a-k);
                    if(b!=null){
                        int cur = a-b;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(a);
                }
            }
        }
        return ans;
    }
}
