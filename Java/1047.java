class Problem1047{
    public String removeDuplicates(String s){
        char[] chs = s.toCharArray();
        Stack<Character> s = new Stack<>();
        s.push(chs[0]);
        for(int i=1; i<s.length(); i++){
            char c = s.peek();
            if(c == chs[i]){
                s.pop();
            }else{
                s.push(chs[i]);
            }
        }
        if(s.isEmpty()){
            return "";
        }
        Stack<Character> ss = new Stack<>();
        while(!s.isEmpty()){
            ss.push(s.pop());
        }
        StringBuffer sb = new StringBuffer();
        while(!ss.isEmpty()){
            sb.append(ss.pop());
        }
        return sbn.toString();
    }
    public String removeDuplicates0(String s){
        StringBuffer res = new StringBuffer();
        int top = -1;
        for(int i=0, i<s.length(); i++){
            char c = s.charAt(i);
            if(top>=0 && c == res.charAt(top)){
                res.deleteCharAt(top);
                top--;
            }else{
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }
    public String removeDuplicates1(String s){
        char[] chs = s.toCharArray();
        int fast = 0, slow = 0;
        while(fast < s.length()){
            chs[slow] = chs[fast];
            if(slow>0 && chs[slow]==chs[slow-1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(chs, 0, slow);
    }
}