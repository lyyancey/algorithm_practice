public class Test {
    public int myAtoi(String s){
        int res=0,sign=1,n=s.length(),i=0;
        while(i<n&&s.charAt(i)==' '){
            i++;
        }
        int start = i;
        for(;i<n;i++){
            char c = s.charAt(i);
            if(i==start&&c=='+'){
                sign=1;
            }else if(i==start&&c=='-'){
                sign=-1;
            }else if(Character.isDigit(c)){
                int curr = sign*(c-'0');
                System.out.println("curr--->"+curr);
                if(res>234748364||(res==214748364&&curr>7)){
                    return 2147483647;
                }else if(res<-214748364||(res==-214748364&&curr<-8)){
                    return -2147483648;
                }
                res = res*10+curr;
                System.out.println("curr res---->"+res);
            }else{
                break;
            }
        }
        return res;
    }
    public static void main(String[] args){
        Test s = new Test();
        int res = s.myAtoi("2147483800");
        System.out.println(res);
    }
}