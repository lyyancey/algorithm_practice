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
        while(right<s.length()){//right 为快指针
            char c = s.charAt(right);//检查快指针指向的字符
            //记录快指针指向的字符在滑动窗口中出现的频率
            windows.put(c, windows.getOrDefault(c, 0)+1);
            //滑动窗口向右移动一个字符
            right++;
            //检查滑动窗口中，快指针指向的字符出现的频率
            //如果大于一说明有重复的字符出现
            while(windows.get(c)>1){
                char c1 = s.charAt(left);
                //此时将左指针指向的字符，从统计字符中移除
                windows.put(c1, windows.get(c1)-1);
                //左指针向右移动一个字符，重复此过程，直至右指针指向的字符在滑动窗口中出现的频率小于等于一
                //此时滑动窗口中，就是一个无重复字符的子串
                left++;
            }
            res = res > right-left?res : right-left;//记录最短子串
        }
        return res;

    }
    public static void main(String[] args){
        Problem3 s = new Problem3();
        int x = s.lengthOfLongestSubstring("pwwkew");
        System.out.println(x);
    }
}