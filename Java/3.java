import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        int rk = 0,res=0;
        for(int i=0;i<n;i++){
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while(rk<n&&!set.contains(s.charAt(rk))){
                set.add(s.charAt(rk))
                rk++;
            }
            res = (rk - i)>res?(rk-i):res;
        }
        return res;
    }
    public int lengthOfLongestSubstring1(String s){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int res=0,right=0,left=0;
        while(right<s.length()){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);
            right++;
            while(map.get(c)>1){
                char c1 = s.charAt(left);
                map.put(c1,map.get(c1)-1);
                left++;
            }
            res = (right-left+1)>res?(right-left+1):res;
        }
        return res;
    }
}