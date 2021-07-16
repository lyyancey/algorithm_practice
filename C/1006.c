#include<stdio.h>
int clumsy(int n){
    int stack[n];
    int index=0,top=0, sum=0;
    stack[top++] = n;
    n--;
    while(n>0){
        switch(index%4){
            case 0: stack[top-1] *= n;break;
            case 1: stack[top-1] /= n;break;
            case 2: stack[top++] = n;break;
            case 3: stack[top++] = -n;break;
        }
        n--;
        index++;
    }
    while(--top>=0){
        sum += stack[top];
    }
    return sum;
}
