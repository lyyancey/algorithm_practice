import java.util.*;
class Problem56 {
    public int[][] merge(int[][] intervals) {
        //将数组中的区间按升序排列
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
        //创建一个新数据来存储合并后的区间
        int[][] s = new int[intervals.length][2];
        //将index初始化为-1，其实初始化为0也行
        int index = -1;
        for(int[] interval:intervals){
            //将排序后的第一个区间肯定是一个开始区间
            //当前区间的开始大于上一个合并后的区间的结束也是一个新开始的区间
            if(index==-1||s[index][1]<interval[0]){
                s[++index] = interval;
            }else{
                //除了上面的情况之外，还有两种情况：
                //一个是，当前区间的结束点小于上一个合并区间结束点
                //二是，当前区间的结束点大于上一个合并区间的结束点
                //但是无论哪种情况，都要合并到上一个合并好的区间
                //并将结束点大的那个作为上一个合并区间的结束点
                s[index][1] = Math.max(interval[1], s[index][1]);
            }
        }
        //此时index是指向最后合并后区间，所以长度是index+1
        return Arrays.copyOf(s, index+1);

    }
}
