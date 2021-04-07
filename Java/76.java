import java.util.*;
class Problem76{
    public String minWindow(String s, String t) {
        //记录最短字串的开始位置和长度
        int start = 0, minLen = Integer.MAX_VALUE;
        //滑动窗口的边界
        int left = 0, right = 0;
        Map<Character, Integer> needs = new HashMap<Character, Integer>();
        Map<Character, Integer> windows = new HashMap<Character, Integer>();
        //把所有的T字符串全部放到needs里面
        for(int i = 0;i<t.length();i++){
            needs.put(t.charAt(i),needs.getOrDefault(t.charAt(i),0)+1);
        };
        //记录S字符串已经匹配完成的T字符串中的字符数量
        int match = 0;
        while(right < s.length()){
            char c1 = s.charAt(right);
            if(needs.containsKey(c1)){
                windows.put(c1, windows.getOrDefault(c1, 0)+1);
                if(windows.get(c1).equals(needs.get(c1))){
                    match++;
                }
            }
            right++;
            while(match == needs.size()){
                if(right - left < minLen){
                    //更新最小字覆盖子串的起始位置
                    start = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                if(needs.containsKey(c2)){
                    windows.put(c2, windows.get(c2)-1);
                    if(windows.get(c2) < needs.get(c2)){
                        match--;
                    }
                }
                left++;
            }
        }
        //System.out.println(start);
        //System.out.println(minLen);
        return minLen == Integer.MAX_VALUE ? "":s.substring(start, start + minLen);
    }
    public static void main(String[] args){
        Problem76 p = new Problem76();
        String s = p.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}