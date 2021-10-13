class Problem349{
    public int[] intersection(int[] num1, int[] num2){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int x : num1){
            set1.add(x);
        }
        for(int y : num2){
            if(set1.contains(y)){
                set2.add(y);
            }
        }
        int[] res = new int[set2.size()];
        int i=0;
        for(int x : set2){
            res[i++] = x;
        }
        return res;
    }
}