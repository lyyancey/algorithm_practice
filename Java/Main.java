import java.util.*;
public class Main {
    public int findX() {
        Scanner input = new Scanner(System.in);
        int len = input.nextInt();
        int[][] points = new int[len][2];
        for(int i = 0;i<len;i++){
            points[i][0] = input.nextInt();
            points[i][1] = input.nextInt();
        }
        input.close();
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
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
            if(x[0]>=startEnd){
                startEnd = x[1];
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Main s = new Main();
        int x = s.findX();
        System.out.print(x);
    }
}
