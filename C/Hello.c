#include<stdio.h>
int main(){
    int a=1;
    int &b=a;
    int*c=&a;
    b=2;
    printf("%d, %d", a, *c);
    return 0;
}