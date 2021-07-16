#include<stdio.h>
//加法运算
int missingNumber0(int* nums, int numsSize){
    int res = 0;
    for(int i=1;i<=numsSize;i++){
        res += i;
        res -= nums[i-1];
    }
    return res;
}
//按位与
int missingNumber(int* nums, int numsSize){
    int res = 0;
    for(int i=1;i<=numsSize;i++){
        res ^= i;
        res ^= nums[i-1];
    }
    return res;
}