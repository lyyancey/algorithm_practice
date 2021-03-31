/**
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，
 * 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
*/
#include<stdio.h>
int rangeBitwiseAnd(int left, int right){
    /**
     * 暴力解法就是两个数逐一按位与，但是这样操作，时间复杂度太高，
     * 因此需要另寻他路。
     * 首先明确：
     * 0 & 0 = 0
     * 0 & 1 = 1 & 0 =0
     * 1 & 1 = 1
     * 所以， 两个数按位与，则用二进制表示时，一的个数只会减少或者不变而不会增加。
     * 我们将[16, 32]区间的数用二进制表示出来
     * 0001 0000
     * 0001 0001
     * 0001 0010
     * 0001 0011
     * 0001 0100
     *     |
     * 0010 0000
     * 这时，我们就能看到，每个区间内的数字用二进制表示出来之后，总会有一个共同的前缀，
     * 上面的例子不明显，前缀全部为零了。
     * 则他们共同的前缀为下界，那么方法就比较简单了：
     *
     * 其实就是一个二进制表达力的问题
     * 某一个区间，用二进制表示的话，从下界到上界，会有一个共同的前缀和肯定各不相同的后缀。
     * 二后缀的各不相同导致每一位按位与时，肯定为零，问题就转化成了求他们的前缀。
    */
    while(right > left){
       right &= (right-1);
    }
    return right;
}
int main(){
    int x = rangeBitwiseAnd(1, 2147483647);
    printf("%d\n", x);
    return 0;
}