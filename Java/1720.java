class Problem1720 {
    public int[] decode(int[] encoded, int first) {
        int[] list = new int[encoded.length+1];
        list[0] = first;
        for(int i = 0; i<encoded.length;i++){
            first = first ^ encoded[i];
            list[i+1] = first;
        }
        return list;
    }
}
