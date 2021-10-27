class Problem459{
    public boolean repeatedSubstringPattern(String s){
        int n = s.length();
        for(int i=1; i * 2 < n; i++){
            if(n % i == 0){
                boolean match = true;
                for(int j = i; j<n; j++){
                    if(s.charAt(j) != s.charAt(j-i)){
                        match = false;
                        break;
                    }
                }
                if(match){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean repeatedSubstringPattern0(String s){
        if("".equals(s))return false;
        int[] N = this.buildNext(s);
        int len = s.length();
        if(N[len-1]>0 && len % (len - (N[len-1])+1) == 0){
            return true;
        }
        return false;
    }
    private int[] buildNext(String s){
        int m = s.length(), j = 0;
        int[] N = new int[m];
        int t = N[0] = -1;
        while(j < m-1){
            if(0>t || s.charAt(j) == s.charAt(t)){
                N[++j] = ++t;
            }else{
                j = N[t];
            }
        }
        return N;
    }
}