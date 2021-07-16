class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while(right > left){
            right &= (right-1);
        }
        return right;
        /**
        //错误原因是right也变了
        while(right >left){
            right &= (left++);
        }
        return right;
        */
    }
}