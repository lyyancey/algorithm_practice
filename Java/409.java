class Problem409{
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int res = 0;
        for(char c : map.keySet()){
            int num = map.get(c);
            num -= (num%2);
            res += num;
        }
        if(res != s.length()){
            res++;
        }
        return res;
    }
}