class Problem91{
    public int numDecodings(String s) {
        int n = s.length();
        s = " " + s;
        char[] arr = s.toCharArray();
        int[] f = new int[n+1];
        f[0] = 1;
        for(int i=1;i<=n;i++){
            int a=arr[i]-'0',b = (arr[i-1]-'0')*10 + (arr[i]-'0');
            if(a>=1&&a<=9)f[i] = f[i-1];
            if(b>=10&&b<=26)f[i]+=f[i-2];
        }
        return f[n];
    }
}