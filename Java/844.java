import java.util.Stack;


class Problem844{
    public boolean backspaceCompare(String s, String t){
        Stack<Character> ss = new Stack<>();
        Stack<Character> tt = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '#'){
                if(!ss.empty()){
                    ss.pop();
                }
                continue;
            }
            ss.add(c);
        }
        for(int i = 0;i<t.length();i++){
            char c = t.charAt(i);
            if(c == '#'){
                if(!tt.empty()){
                    tt.pop();
                }
                continue;
            }
            tt.add(c);
        }
        if(tt.size()!=ss.size())return false;
        while(!tt.isEmpty()){
            if(tt.pop() != ss.pop()){
                return false;
            }
        }
        return true;
    }
    public boolean backspaceCompare0(String s, String t){
        int i = s.length()-1,j = t.length()-1, skipS = 0, skipT = 0;
        while(i>=0 || j>=0){
            while(i >= 0){
                if(s.charAt(i) == '#'){
                    skipS++;
                    i--;
                }else if(skipS > 0){
                    skipS--;
                    i--;
                }else{
                    break;
                }
            }
            while(j >= 0){
                if(t.charAt(j) == '#'){
                    skipT++;
                    j--;
                }else if(skipT > 0){
                    skipT--;
                    j--;
                }else{
                    break;
                }
            }
            if(i>=0 && j>=0){
                if(s.charAt(i) != t.charAt(j)){
                    return false;
                }
            }else if(i>=0 || j>=0){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
