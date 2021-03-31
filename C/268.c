#include<stdio.h>

// 求和版
int missingNumber0(int* nums, int numsSize){
    int sum = 0;
    for(int i=0;i<numsSize;i++){
        sum += i;
        sum -= nums[i];
    }
    return (sum+numsSize);
}
//位操作版
int missingNumber(int* nums, int numsSize){
    int res = numsSize; 
    for(int i=0;i<numsSize;i++){
        res ^= nums[i];
        res ^= i;
    }
    return res;
}
int main(){
    int i[3] = {3, 0, 1};
    int k = 3;
    int res = missingNumber(i, k);
    printf("%d\n", res);
    return 0;
}