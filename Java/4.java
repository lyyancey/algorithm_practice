import java.util.*;
class Problem4{
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int x = nums1.length, y = nums2.length;
    List<Integer> l = new ArrayList<Integer>();
    for(int i=0,j=0;i<x||j<y;){
      while((i<x)&&(j>=y||nums1[i]<nums2[j]))l.add(nums1[i++]);
      while((j<y)&&(i>=x||nums1[i]>=nums2[j]))l.add(nums2[j++]);
    }
    int len = x+y;
    if(len%2==1){
      return (double)l.get(len/2);
    }
    return ((double)l.get(len/2)+(double)l.get(len/2-1))/2; 
  }
  public static void main(String[] args) {
    Problem4 p = new Problem4();
    int x[] = {1,2},y[]={3, 4};
    double t = p.findMedianSortedArrays(x, y);
    System.out.println(t);
  }
}
