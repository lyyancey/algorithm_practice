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
    public int lengthOfLongestSubstring2(String s) {
        int res = 0, left = 0, right = 0;
        Map<Character, Integer> windows = new HashMap<Character, Integer>();
        while(right<s.length()){
            char c = s.charAt(right);
            windows.put(c, windows.getOrDefault(c, 0)+1);
            right++;
            while(windows.get(c)>1){
                char c1 = s.charAt(left);
                windows.put(c1, windows.get(c1)-1);
                left++;
            }
            res = res > right-left?res :right-left;
        }
        return res;

    }
    public static void main(String[] args){
        Problem3 s = new Problem3();
        int x = s.lengthOfLongestSubstring("pwwkew");
        System.out.println(x);
    }
}