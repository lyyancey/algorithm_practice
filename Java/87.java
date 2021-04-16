import java.util.*;
class Problem87{
    public boolean isScramble1(String s1, String s2) {
        //两个字符串相等直接返回true
        if(s1.equals(s2))return true;
        //两个字符串长度不相等，必然不是扰乱字符串
        if(s1.length()!=s2.length())return false;
        if(s1==null||s2==null)return false;
        int[] letter = new int[26];
        for(int i=0;i<s1.length();i++){
            letter[s1.charAt(i)-'a']++;
            letter[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(letter[i]!=0)return false;
        }
        for(int i = 1;i<s1.length();i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i), s2.substring(i)))return true;
            if(isScramble(s1.substring(0, i), s2.substring(s2.length()-i))&&isScramble(s1.substring(i), s2.substring(0,s2.length()-i)))return true;
        }
        return false;
    }
    String s1,s2;
    int n;
    int[][][] cache;
    int N=-1,Y=1,EMPTY=0;
    public boolean isScramble(String _s1, String _s2){
        s1 = _s1;
        s2 = _s2;
        if(s1==null||s2==null)return false;
        if(s1.equals(s2))return true;
        if(s1.length()!=s2.length())return false;
        n = s1.length();
        cache = new int[n][n][n+1];
        return dfs(0, 0, n);
    }
    public boolean dfs(int i, int j, int len){
        if(cache[i][j][len]!=EMPTY)return cache[i][j][len]==Y;
        String a = s1.substring(i, i+len), b=s2.substring(j, j+len);
        if(a.equals(b)){
            cache[i][j][len] = Y;
            return true;
        }
        if(!check(a, b)){
            cache[i][j][len]=N;
            return false;
        }
        for(int k=1;k<len;k++){
            if(dfs(i, j, k)&&dfs(i+k, j+k, len-k)){
                //对应了 s1的[0, i) & [i, 0) 匹配 s2的[0, i)&&[i, n)
                cache[i][j][len]=Y;
                return true;
            }
            if(dfs(i, j+len-k, k) && dfs(i+k, j,len-k)){
                //对应了s1的[0, i) &&[i, n) 匹配 s2的[n-i, n)&&[0, n-i)
                cache[i][j][len-k] = Y;
                return true;
            }
        }
        cache[i][j][len] = N;
        return false;
    }
    public boolean check(String s1,String s2){
        int[] letter = new int[26];
        for(int i=0;i<s1.length();i++){
            letter[s1.charAt(i)-'a']++;
            letter[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(letter[i]!=0)return false;
        }
        return true;
    }
}
