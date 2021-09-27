class MergeSort{
    private void merge(int[] rank, int lo, int mi, int hi){
        int rb = mi - lo;
        int rc = hi - mi;
        int[] B = new int[rb];
        for(int i=0;i<rb; i++)B[i] = rank[lo + i];
        for(int i=0, j=0, k=0;(i<rb||j<rc);){
            if((i<rb)&&(rc<=j||B[i]<=rank[mi+j])){
                rank[lo + k] = B[i++];
                k++;
            }
            if((j<rc)&&(rb<=i||rank[mi+j]<B[i])){
                rank[lo + k] = rank[mi + j++];
                k++;
            }
        }
    }
    public void mergeSort(int[] rank, int lo, int hi){
        if(hi - lo < 2)return;
        int mid = (hi + lo)>>1;
        mergeSort(rank, lo, mid);
        mergeSort(rank, mid, hi);
        merge(rank, lo, mid, hi);
    }
    public static void main(String[] args){
        MergeSort s = new MergeSort();
        int[] A = new int[]{1,3,5,4,2,7,6,8,9,0};
        s.mergeSort(A, 0, 10);
        for(int i=0;i<10;i++)System.out.println(A[i]);
    }
}