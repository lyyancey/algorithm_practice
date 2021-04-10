import java.util.*;
class Problem438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<Integer>();
        //left为滑动窗口的左边界，right为滑动窗口的右边界，
        //match 为滑动窗口中对匹配的字符串已经匹配好的字符数量
        int left= 0, right = 0, match = 0;
        /**
         * needs 中的key是匹配字符串的每个字符，value是该字符在匹配字符串中出现的次数
         * windows 是在被匹配字符串上的滑动窗口中，记录与匹配字符串匹配的字符的状态，它的key是当前滑动窗口中，存在在匹配字符串中的字符，
         * value 是该字符在滑动窗口中出现的次数
         */
        Map<Character, Integer> needs = new HashMap<Character, Integer>();
        Map<Character, Integer> windows = new HashMap<Character, Integer>();
        //统计匹配字符串中出现的字符以及其出现的次数
        for(int i = 0; i<p.length();i++){
            needs.put(p.charAt(i), needs.getOrDefault(p.charAt(i), 0)+1);
        }
        /**
         * 利用快慢指针来指示窗口边界
         * right 表示右边界，left表示左边界，循环的结束条件是右边界越界
         */
        while(right<s.length()){
            /**
             * 起始时左右边界均指向第一个字符
             */
            char c1 = s.charAt(right);
            //如果右边界指向的字符在匹配的字符串当中
            if(needs.containsKey(c1)){
                //则将该字符在滑动窗口中出现的次数记录在windows中
                windows.put(c1, windows.getOrDefault(c1, 0)+1);
                //如果该字符在滑动窗口中出现的次数与匹配字符串中出现的次数相同，则说明已经有一个完全匹配的的字符
                if(windows.get(c1).equals(needs.get(c1))){
                    //故 match++
                    match++;
                }else{
                    //这里其实还隐藏着一个else，如果出现的次数不相同，则什么都不做
                }
            }//else 如果该字符不在匹配字符串中，则什么都不做
            //滑动窗口的边界向右扩展一个字符
            right++;
            /**
             * 如果滑动窗口中的字符出现的情况与匹配字符串的情况一致
             * 也就是match 与匹配字符串的长度一致，则说明滑动窗口可以完全匹配匹配字符串了
             */
            while(match == needs.size()){
                /**这时候如果滑动窗口的长度如果等于匹配字符串的长度
                 * 说明滑动窗口中各个字符出现的频率，与匹配字符串出现的频率相同
                 * 只是顺序不一样（也可能一样）
                */
                if(right-left == p.length()){
                    //这时候就将符合要求的左边界保存起来
                    res.add(left);
                }
                /**
                 * 保存好之后，检查左边界是否在匹配字符串中
                 */
                char c2 = s.charAt(left);
                //如果左边界指向的字符串在匹配字符串中
                if(needs.containsKey(c2)){
                    //则将该字符串出现在窗口中的记录删除
                    windows.put(c2, windows.get(c2)-1);
                    //查看该字符串在滑动窗口中出现的频率是否小于匹配字符串中该字符出现的频率
                    if(windows.get(c2) < needs.get(c2)){
                        //小于的话，说明窗口中的该字符不能与匹配字符串中的字符相匹配了
                        //所以已经匹配的字符应该减一
                        match--;
                    }
                }
                //滑动窗口的左边界向右滑动一个字符
                //这个操作其实是一个缩小滑动窗口的操作
                //缩小到滑动窗口内的字符已经不能匹配匹配字符串的时候
                //也就是不满足while的循环条件时
                left++;
            }
        }

        return res;
    }
    public static void main(String[] args){
        Problem438 p = new Problem438();
        p.findAnagrams("xxx", "xxxx");
    }
}
