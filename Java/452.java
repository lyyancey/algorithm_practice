import java.util.*;
class Problem452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if(o1[1]<o2[1]){
                    return -1;
                }else if(o1[1]>o2[1]){
                    return 1;
                }
                return 0;
            }
        });
        int ans = 1;
        int startEnd = points[0][1];
        for(int[] x : points){
            if(x[0]>startEnd){
                startEnd = x[1];
                ans++;
            }
        }
        return ans;
    }
}
