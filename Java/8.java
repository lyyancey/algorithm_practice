class Problem8{
    public int myAtoi(String s){
        int res=0,n=s.length(),sign=1,i=0;
        while(i<n&&s.charAt(i)==' '){
            i++;
        }
        int start = i;
        for(;i<n;i++){
            char c = s.charAt(i);
            if(i==start&&c=='+'){
                sign = 1;
            }else if(i==start&&c=='-'){
                sign=-1;
            }else if(Character.isDigit(c)){
                int num = (c - '0')*sign;
                if(res>214748364||(res==214748364&&num>7)){
                    return 2147483647;
                }
                if(res<-214748364||(res==-214748364&&num<-8)){
                    return -2147483648;
                }
                res = res*10+num;
            }else{
                break;
            }
        }
        return res;
    }
}