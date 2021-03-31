#include<stdio.h>
int main(){
    int k = 1,l = 1;
    k ^= l;
    l ^= k;
    k ^= l;
    printf("%d, %d\n", k, l);
    return 0;
}
