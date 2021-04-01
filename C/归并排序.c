#include<stdio.h>
#include<stdlib.h>
void merge(int* rank, int lo, int mi, int hi){
    int* A = rank + lo;//合并后的向量A[0, hi - lo) = rank[lo, hi)
    int lb = mi - lo;
    int* B = (int*)malloc(sizeof(int)*lb);//前子向量B[0,lb) = rank[lo, mi)
    //这里用的 i<lb 表示复制的范围是A[0,lb)
    for(int i = 0;i<lb;i++)B[i]=A[i];// 复制前子向量B
    int lc = hi - mi;
    int* C = rank + mi;//后子向量C[0,lc] = rank[mi, hi)
    /**
     * 1.这里循环结束的条件是：当
    */
    for(int i=0,j=0,k=0;(j < lb) || (k < lc);){//B[j] 和C[k]中小者转至A的末尾
        if( (j < lb) && (lc <= k || (B[j] <= C[k]) ) )A[i++] = B[j++];//C[k]已无或不小
        if( (k < lc) && (lb <= j || (C[k] < B[j]) ) )A[i++] = C[k++];//B[j]已无或更大
    }// 该循环实现紧凑；但就效率而言，不如拆分处理
    free(B);
}
void mergeSort(int* rank, int lo, int hi){//[lo, hi)
    if(hi-lo<2)return; //处理递归基，单元素区间自然有序
    int mi = (lo + hi)>>1; //以中点为界
    mergeSort(rank, lo, mi);//对前半段排序
    mergeSort(rank, mi, hi);//对后半段进行排序
    merge(rank, lo, mi, hi);//归并
}
int main(){
    int* a = (int*)malloc(sizeof(int)*10);
    a[0] = 0;
    a[1] = 6;
    a[2] = 3;
    a[3] = 5;
    a[4] = 2;
    a[5] = 7;
    a[6] = 4;
    a[7] = 9;
    a[8] = 1;
    a[9] = 8;
    mergeSort(a, 0, 10);
    for(int i = 0; i<10; i++)printf("%d\n", a[i]);
    return 0;
}