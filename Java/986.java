import java.util.*;
class Problem986{
    public int[][] intervalIntersection(int[][] f, int[][] s) {
        List<int[]> l = new ArrayList<>();
        int a=0,b=0;
        while(a<f.length&&b<s.length){
            int left = Math.max(f[a][0], s[b][0]);
            int right = Math.min(f[a][1], s[b][1]);
            if(left<right){
                l.add(new int[]{left, right});
            }
            if(f[a][1]<s[b][1]){
                a++;
            }else{
                b++;
            }
        }
        return l.toArray(new int[0][]);
    }
}
