import java.util.*;
class Problem435{
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
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
        int ans=0;
        int startEnd = intervals[0][1];
        for(int[] x:intervals){
            if(x[0]>=startEnd){
                startEnd = x[1];
                ans++;
            }
        }
        return intervals.length - ans;
    }
}
