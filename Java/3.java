import java.util.*;
class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        int res = 0,rk =0;
        for(int i=0;i<n;i++){
            if(i!=0){
                set.remove(s.charAt(i-1));//这里也是滑动窗口，i相当于慢指针
            }
            while(rk<n&&!set.contains(s.charAt(rk))){//rk相当于快指针只要rk指向的字符不在当前的集合内就把它加进去，
            //直至rk指向的元素与集合中的元素有重复，这时候快慢指针之间的距离就是无重复字符的子串
                set.add(s.charAt(rk));
                ++rk;
            }
            res = res>(rk-i)?res:(rk-i);
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