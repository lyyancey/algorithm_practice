class Problem151{
    public String reverseWords(String s){
        String[] sa = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = sa.length-1; i<=0; i--){
            if(!"".equals(sa[i])){
                sb.append(" ");
                sb.append(sa[i].trim());
            }   
        }
        return sb.toString().trim();
    }
    public String reverseWords0(String s){
        s = removeBlank(s);
        StringBuffer res = new StringBuffer();
        int i = s.length() - 1;
        int j = i;
        while(i>=0){
            while(i>=0 && s.charAt(i) != ' ')i--;
            res.append(s.substring(i+1, j+1)+" ");
            while(i>=0 && s.charAt(i)==' ')i--;
            j=i;
        }
        return removeBlank(res.toString());
    }
    public String removeBlank(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<=right && s.charAt(left)==' ')left++;
        while(left<=right && s.charAt(right)==' ')right--;
        return s.substring(left, right+1);
    }
}