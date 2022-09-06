class Problem512{
    public int numDecodings(String s) {
        char[] ss = s.toCharArray();
        int n = s.length();
        if(n==0){
            return 0;
        }
        int[] f = new int [n+1];
        f[0] = 1;
        for(int i=1; i<=n; i++){
            int t = ss[i-1] - '0';
            if(t>1&&t<=9){
                f[i]+=f[i-1];
            }
            if(i>=2){
                int x = (ss[i-2]-'0')*10 + t;
                if(x>=10&&x<=26){
                    f[i] += f[i-2];
                }
            }
        }
        return f[n];
    }
}
