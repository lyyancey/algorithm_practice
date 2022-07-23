import java.util.HashMap;
import java.util.Map;

class Problem10{
    Map<String, Boolean> map = new HashMap<>();
    public boolean isMatch(String s, String p){
        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j){
        int m = s.length(), n = p.length();
        if(j == n){
            return i == m;
        }
        if(i == m){
            if((n-j)%2==1) return false;
            for(;j+1<n;j+=2){
                if(p.charAt(j+1) != '*'){
                    return false;
                }
            }
            return true;
        }
         String key = i+","+j;
        if(map.containsKey(key)){
            return map.get(key);
        }
        boolean res = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            if(j+1<n && p.charAt(j+1) == '*'){
               res = dp(s, i, p, j+2) || dp(s, i+1, p, j);
            }else{
                res = dp(s, i+1, p, j+1);
            }
        }else{
            if(j+1<n && p.charAt(j+1) == '*'){
                res = dp(s, i, p, j+2);
            }else{
                res = false;
            }
        }
        map.put(key, res);
        return res;
    }
    // 自底向上的解法
    public boolean isMatch0(String ss, String pp){
        int n = ss.length(), m = pp.length();
        ss = " "+ss; pp = " " + pp;
        char[] s = ss.toCharArray(), p = pp.toCharArray();
        boolean[][] f = new boolean[n+1][m+1];
        f[0][0] = true;
        for(int i = 0; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(j+1 <=m && p[j+1] == '*') continue;
                if(i-1>=0 && p[j]!='*'){
                    f[i][j] = f[i-1][j-1] &&(s[i] == p[j] || p[j] == '.');
                }else if(p[j] == '*'){
                    f[i][j] = (j-2>=0 && f[i][j-2])||(i-1>=0 && f[i-1][j]&&(s[i]==p[j-1]||p[j-1]=='.'));
                }
            }
        }
        return f[n][m];
    }
}