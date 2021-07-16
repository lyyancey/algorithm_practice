class Solution {
    public int trap(int[] height) {
        int high =1, sum=0,volum=0,left=0,right=height.length-1;
        for(int i=0;i<height.length;i++){
            sum+=height[i];
        }
        while(left<=right){
            while(left<=right&&height[left]<high)left++;
            while(left<=right&&height[right]<high)right--;
            high++;
            volum+=right-left+1;
        }
        return volum - sum;
    }
}