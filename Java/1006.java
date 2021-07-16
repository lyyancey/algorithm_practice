class Solution {
    public int clumsy(int n) {
        int[] stack = new int[n];
        int top=0,sum=0,index=0;
        stack[top++] = n;
        while(n>1){
            n--;
            switch(index % 4){
                case 0:stack[top-1] *= n;break;
                case 1:stack[top-1] /= n;break;
                case 2:stack[top++] = n;break;
                case 3:stack[top++] = -n;break;
            }
            index++;
        }
        while(--top>=0){
            sum+=stack[top];
        }
        return sum;
    }
}