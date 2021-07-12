public class Solution {
    public int hammingWeight(int n) {
        int k = 0;
        while(n != 0){
            n &= (n-1);
            k++;
        }
        return k;
    }
}