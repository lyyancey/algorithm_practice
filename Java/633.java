class Problem633 {
    public boolean judgeSquareSum(int c) {
        int n = (int)Math.sqrt(c);
        for(int i=0;i<=n;i++){
            int b = (int)Math.sqrt(c - i*i);
            if(i*i+b*b==c){
                return true;
            }
        }
        return false;
    }
    public boolean judgeSquareSum0(int c) {
        int n = (int)Math.sqrt(c);
        int a =0, b=n;
        while(a<b){
            if(a*a+b*b==c){
                return true;
            }else if(a*a+b*b<c){
                a++;
            }else if(a*a+b*b>c){
            }else if(a*a+b*b>c){
                b--;
            }
        }
        return false;
    }
}