#include<stdio.h>
int main(){
    
    //利用'|'和' '将英文字符转换为小写
    char b = ('b' | ' ');
    char B = ('b' | ' ');
    printf("%c\n", b); // b
    printf("%c\n", B); // b
    
    //利用'&' 和 '_'将英文字母转换为大写
    char a = ('a' & '_');
    char A = ('A' & '_');
    printf("%c\n", a);// A
    printf("%c\n", A);// A
    
    //利用'^' 和 ' '进行字符的大小写转换
    printf("%c\n", ('A' ^ ' ')); //a
    printf("%c\n", ('a' ^ ' ')); //A
    
    //判断两个数是否异号
    int x=1,y=2;
    printf("%d\n", ((x ^ y)<0));// 0  false
    x=2;
    y=-2;
    printf("%d\n", ((x ^ y)<0)); //1 true

    //不用临时变量交换两个数；
    int t=1, g=2;
    t ^= g;
    g ^= t;
    t ^= g;
    printf("t = %d, g = %d\n", t, g);// t=2,g=1

    //加一
    int n = 1;
    n = -~n;
    printf("%d\n", n);

    //减一
    int k = 2;
    k = ~-k;
    printf("%d\n", k);
    /**
     * 重点:
     * n&(n-1)
     * 作用是消除数字n的二进制表示中的最后一个一
    */
    int p = 3;
    printf("%d\n", p&(p-1));// 2
    return 0;
}