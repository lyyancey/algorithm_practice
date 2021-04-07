import java.util.*;
class Problem438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<Integer>();
        int left= 0, right = 0, match = 0;
        Map<Character, Integer> needs = new HashMap<Character, Integer>();
        Map<Character, Integer> windows = new HashMap<Character, Integer>();
        for(int i = 0; i<p.length();i++){
            needs.put(p.charAt(i), needs.getOrDefault(p.charAt(i), 0)+1);
        }
        while(right<s.length()){
            char c1 = s.charAt(right);
            if(needs.containsKey(c1)){
                windows.put(c1, windows.getOrDefault(c1, 0)+1);
                if(windows.get(c1).equals(needs.get(c1))){
                    match++;
                }
            }
            right++;
            while(match == needs.size()){
                if(right-left == p.length()){
                    res.add(left);
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
        return res;
    }
    public static void main(String[] args){
        Problem438 p = new Problem438();
        p.findAnagrams("xxx", "xxxx");
    }
}
