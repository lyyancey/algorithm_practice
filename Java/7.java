class Solution {
    public int reverse(int x) {
        int res =0,tem=0;
        while(x!=0){
            tem = x%10;
            if(res>214748364||(res==214748364&&tem>7)){
                return 0;
            }
            if(res<-214748364||(res==-214748364&&tem<-8)){
                return 0;
            }
            res=res*10+tem;
            x/=10;
        }
        return res;
    }
}