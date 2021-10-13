class ProblemOffer05{
    public String replaceSpace(String s){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public String replaceSpace0(String s){
        return s.replace(" ", "%20");
    }
    public String replaceSpace1(String s){
        char[] sc = s.toCharArray();
        int oldSize = sc.length, count = 0;
        for(int i=0; i<oldSize; i++){
            if(sc[i] == ' '){
                count++;
            }
        }
        sc = Arrays.copyOf(sc, oldSize+count*2);
        int newSize = sc.length;
        for(int i=oldSize-1, j=newSize-1;i<j;i--,j--){
            if(sc[i] != ' '){
                sc[j] = sc[i];
            }else{
                sc[j] = '0';
                sc[j-1] = '2';
                sc[j-2] = '%';
                j -= 2;
            }
        }
        return String.valueOf(sc);
    }
}