import java.util.*;
class Problem54{
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> list = new LinkedList<>();
        if(matrix==null || matrix[0].length==0){
            return list;
        }
        int total = matrix.length * matrix[0].length;
        int left = 0,right = matrix[0].length-1, bottom = matrix.length-1, top = 0;
        while(total >= 1){
            for(int i = left;i<=right&&total>0;i++){
                list.add(matrix[top][i]);
                total--;
            }
            top++;
            for(int i = top;i<=bottom&&total>0;i++){
                list.add(matrix[i][right]);
                total--;
            }
            right--;
            for(int i = right;i>=left&&total>0;i--){
                list.add(matrix[bottom][i]);
                total--;
            }
            bottom--;
            for(int i = bottom;i>=top&&total>0;i--){
                list.add(matrix[i][left]);
                total--;
            }
            left++;
        } 
        return list;
    }
}
