#include<stdio.h>

int trap(int* height, int heightSize){
    int sum = 0,left = 0, right = heightSize-1;
    int volumel =0, high = 1;
    for (int i=0;i<heightSize;i++){
        sum += height[i];
    }
    while(left <= right){
        while(left<=right&&height[left]<high)left++;
        while (left<=right&&height[right]<high)right--;
        volumel += right-left+1;
        high++;
    }
    return volumel-sum;
}
int main(){
    int a[12] = {0,1,0,2,1,0,1,3,2,1,2,1}, height = 12;
    int x = trap(a, 12);
    printf("%d\n",x);
    return 0;
}