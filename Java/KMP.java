class KMP{
    int match(String P, String T){
        int[] next = buildNext(P); // 构造next指针
        int n = T.length(), i = 0; //文本串指针
        int m = P.length(), j = 0; // 模式串指针
        while(j < m && i<n){ // 自左向右，逐个字符比对
            if(0 > j || T.charAt(i) == P.charAt(j)){ // 若匹配
                i++;j++; //则携手并进
            }else{ // 否则 P右移，T不回退
                j = next[j];
            }
        }
        return i - j;
    }
    int[] buildNext(String P){ // 构造模式串P的next[] 表
        int m = P.length(), j = 0;  // "主"串指针
        int[] N = new int[m]; //next[] 表
        int t = N[0] = -1; //模式串指针 (P[-1]通配符)
        while(j < m-1){
            if(0 > t || P.charAt(j) == P.charAt(t)){ // 匹配
                N[++j] == ++t;
            }else{ // 失配
                t = N[t];
            }
        }
        return N;
    }
}