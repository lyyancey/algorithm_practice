class Problem17{
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits){
        if(digits.length()==0){
            return res;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        int len = digits.length();
        StringBuffer track = new StringBuffer();
        backtrack(map, digits, 0, track);
        return res;
    }
    private void backtrack(Map<Character, String> map, String digits, int index, StringBuffer track){
        if(index == digits.length()){
            res.add(new String(track));
            return;
        }
        String digitsString = map.get(digits.charAt(index));
        for(char c : digitsString.toCharArray()){
            // 做选择
            track.append(c);
            // 回溯
            backtrack(map, digits, index+1, track);
            // 撤销选择
            track.deleteCharAt(track.length()-1);
        }
    }
}