#include<stdio.h>
//题目链接https://leetcode-cn.com/problems/clumsy-factorial/
int clumsy(int N){
    int stack[N];
    int index = 0, top = 0, sum=0;
    stack[top++] = N;
    N--;
    while(N>0){
        switch (index%4){
            case 0:stack[top-1] *= N;break;
            case 1:stack[top-1] /= N;break;
            case 2:stack[top++] = N;break;
            case 3:stack[top++] = -N;break;
        }
        N--;
        index++;
    }
    while((--top)>=0){
        sum += stack[top];
    }
    return sum;
}
int main(){
    int x = clumsy(10);
    printf("%d\n", x);
}