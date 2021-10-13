class Problem541{
    public String reverseStr(String s, int k){
        char[] sc = s.toCharArray();
        for(int i=0;i<sc.length-1;i+=2*k){
            int t = 0;
            // if(i+k>=sc.length){
            //     t = sc.length-1;
            // }else{
            //     t = i+k-1;
            // }
            t = Math.min(i+k, sc.length);
            int lo = i, hi = t;
            while(lo < hi ){
                char c = sc[lo];
                sc[lo] = sc[hi];
                sc[hi] = c;
                lo++;
                hi--;
            }
        }
        return sc.toString()
    }
    public String reverseStr0(String s, int k){
        char[] sc = s.toCharArray();
        int n = sc.length;
        for(int i=0;i<n;i+=2*k){
            int hi = Math.min(i+k-1, n-1);
            for(int lo=i;lo<hi;lo++, hi--){
                char c = sc[lo];
                sc[lo] = sc[hi];
                sc[hi] = c;
            }
        }
        return String.valueOf(sc);
    }
}