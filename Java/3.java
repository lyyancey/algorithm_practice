import java.util.*;
class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        int res = 0,rk =0;
        for(int i=0;i<n;i++){
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while(rk<n&&!set.contains(s.charAt(rk))){
                set.add(s.charAt(rk));
                ++rk;
            }
            res = res>(rk-i)?res:(rk-1);
        }
        return res;
    }
    public static void main(String[] args){
        Problem3 s = new Problem3();
        int x = s.lengthOfLongestSubstring("pwwkew");
        System.out.println(x);
    }
}