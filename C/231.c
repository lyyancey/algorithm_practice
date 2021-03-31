/**
 * 题目描述：
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
*/
#include<stdio.h>
typedef enum bool {false=0,true=1}bool;
bool isPowerOfTwo(int n){
    //如果是二的幂,那么这个数的二进制表示只能有一个一并且必须大于零；
    return ((n>0)&&((n&(n-1))==0));
}
int main(){
    bool x = isPowerOfTwo(32);
    printf("%d", x);
}