import java.util.*;
class Problem56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if(o1[0]<o2[0]){
                    return -1;
                }else if(o1[0]>o2[0]){
                    return 1;
                }
                return 0;
            }
        });
        int[][] s = new int[intervals.length][2];
        int index = -1;
        for(int[] interval:intervals){
            if(index==-1||s[index][1]<interval[0]){
                s[++index] = interval;
            }else{
                s[index][1] = Math.max(interval[1], s[index][1]);
            }
        }
        return Arrays.copyOf(s, index+1);

    }
}
