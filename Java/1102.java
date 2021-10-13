class Problem1102{
    public List<String> commonChars(String[] words){
        int[] minMap = new int[26];
        for(char c : words[0].toCharArray()){
            minMap[c - 'a'] += 1;
        }
        for(int i=1;i<words.length;i++){
            int[] map = new int[26];
            for(char c : words[i].toCharArray()){
                map[c - 'a'] += 1;
            }
            for(int k = 0;k<26;k++){
                minMap[k] = Math.min(minMap[k], map[k]);
            }
        }
        List<String> l = new LinkedList<>();
        for(int i=0;i<26;i++){
            for(int k =0;k<minMap[i];k++){
                l.add(String.valueOf((char)('a'+i)));
            }
        }
        return l;
    }
}