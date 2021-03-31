#include<stdio.h>
/**
 * 这是一个main()函数
**/
int main(){
    int k = 1,l = 1;
    k ^= l;
    l ^= k;
    k ^= l;
    printf("%d, %d\n", k, l);
    return 0;
}
