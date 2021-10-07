class Problem242{
    public boolean isAnagram(String s, String t){
        int[] ht = new int[26];
        for(char c : s.toCharArray()){
            ht[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            ht[c-'a']--;
        }
        for(int x : ht){
            if(x!=0){
                return false;
            }
        }
        return true;
    }
}