import java.util.*;
class Problem76{
    public String minWindow(String s, String t) {
        //记录最短字串的开始位置和长度
        int start = 0, minLen = Integer.MAX_VALUE;
        //滑动窗口的边界
        int left = 0, right = 0;
        Map<Character, Integer> needs = new HashMap<Character, Integer>();
        Map<Character, Integer> windows = new HashMap<Character, Integer>();
        //把所有的T字符串数显的数量记录在needs里面
        for(int i = 0;i<t.length();i++){
            needs.put(t.charAt(i),needs.getOrDefault(t.charAt(i),0)+1);
        };
        //记录S字符串已经匹配完成的T字符串中的字符数量
        int match = 0;
        //right为快指针
        while(right < s.length()){
            //快指针指向的的字符
            char c1 = s.charAt(right);
            //如果need中包含快指针指向的字符
            if(needs.containsKey(c1)){
                //则将这个在windows记录的数量加一
                windows.put(c1, windows.getOrDefault(c1, 0)+1);
                //如果此时快指针指向的字符c1在windows与needs中的数量相等，则说明有一个字符已经在windows中完全匹配了
                if(windows.get(c1).equals(needs.get(c1))){
                    //此时记录匹配数量的变量加一
                    match++;
                }
            }
            //快指针向右移动一个单位
            right++;
            //如果windows中字符匹配的数量与匹配字符串中字符的数量相同，则说明是一个覆盖字串
            while(match == needs.size()){
                //如果当前覆盖字串小于记录的前面匹配的覆盖字串的最小值还小
                //则更新记录新的覆盖子串的左右位置
                if(right - left < minLen){
                    //更新最小字覆盖子串的起始位置
                    start = left;
                    //记录最小覆盖子串的长度
                    minLen = right - left;
                }
                //c2为慢指针指向的子串
                char c2 = s.charAt(left);
                //如果needs中包含慢指针指向的子串
                if(needs.containsKey(c2)){
                    //将慢指针指向的字符从窗口中记录的数量减一
                    windows.put(c2, windows.get(c2)-1);
                    //如果慢指针指向的字符在windows中的数量小于匹配字符串中的数量
                    if(windows.get(c2) < needs.get(c2)){
                        //则记录匹配数量的变量减一
                        match--;
                    }
                }
                //慢指针向右移动一个字符
                left++;
            }
        }
        //System.out.println(start);
        //System.out.println(minLen);
        //得到最小覆盖子串的长度，没有的话返回空串
        return minLen == Integer.MAX_VALUE ? "":s.substring(start, start + minLen);
    }
    public static void main(String[] args){
        Problem76 p = new Problem76();
        String s = p.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}