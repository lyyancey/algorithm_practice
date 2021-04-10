class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //这其实就是一个从后向前的归并算法
        int t = m+n-1;
        int i=m-1,j=n-1;
        while(i>=0||j>=0){
            while((i>=0)&&(j<0 || nums1[i] >=nums2[j]))nums1[t--] = nums1[i--];
            while((j>=0)&&(i<0 || nums2[j] > nums1[i]))nums1[t--] = nums2[j--];    
        }
    }
    public static void main(String[] args){
        Problem88 p = new Problem88();
        int[] x = {1, 2, 3,0,0,0};
        int[] y = {2, 5, 6};
        p.merge(x, 3, y, 3);
    }
}