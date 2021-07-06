
class Solution {
    public int maxArea(int[] height) {
        int i=0, j=height.length-1, res=0;
        while(i < j){
            res = Math.max(res,height[i]<height[j]? (j-i)*height[i]: (j-i)*height[j]);
            if(height[i]<height[j]) {
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}