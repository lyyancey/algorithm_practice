class Problem383{
    public boolean canConstruct(String ransomNote, String magazine){
        int[] record = new int[26];
        for(char c : magazine.toCharArray()){
            record[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            record[c - 'a']--;
            if(record[c - 'a']<0){
                return false;
            }
        }
        return true;
    }
}