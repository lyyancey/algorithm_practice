#include<stdio.h>
int trap(int* height, int heightSize){
    int sum=0, volum=0,high=1,left=0,right=heightSize-1;
    for(int i=0;i<heightSize;i++){
        sum += height[i];
    }
    while(left <= right){
        while(left<=right&&height[left]<high)left++;
        while(left<=right&&height[right]<high)right++;
        volum+=right-left+1;
        high++;
    }
    return sum - volum;
}